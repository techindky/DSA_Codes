class Solution:
    def subtractProductAndSum(self, n: int) -> int:
        product = 1
        sum1 = 0
        while(n>0):
            sum1+=n%10
            product*=n%10
            n=n//10
        return product - sum1
