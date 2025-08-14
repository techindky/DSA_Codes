class Solution:
    def countGoodNumbers(self, n: int) -> int:
        def power(base, exp):
            result = 1
            while exp > 0:
                if exp % 2 == 1:  # If exp is odd
                    result = (result * base) % 1000000007
                base = (base * base) % 1000000007
                exp = exp // 2
            return result
        if n % 2 == 0:
            return (power(5, n//2)*power(4, n//2)) % 1000000007
        else:
            return (power(5, (n//2)+1)*power(4, (n//2))) % 1000000007
