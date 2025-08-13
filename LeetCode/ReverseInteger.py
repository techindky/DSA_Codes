class Solution:
    def reverse(self, x: int) -> int:
        ans = 0
        if(x>0):
            while(x!=0):
                ans = ans*10 + x%10
                x = x//10
        else:
            x = abs(x)
            while(x!=0):
                ans = ans*10 + x%10
                x = x//10
            ans = -abs(ans)

        if ans in range(pow(-2,31),pow(2,31)):
            return ans
        else:
            return 0
            
