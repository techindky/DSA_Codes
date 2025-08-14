class Solution:
    def isHappy(self, n: int) -> bool:
        temp = n
        for i in range(7):
            temp1 = 0
            s = str(temp)
            for i in s:
                temp1+=int(i)*int(i)
            temp = temp1
            if temp==1:
                return True
