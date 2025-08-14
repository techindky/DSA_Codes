class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        five = 0
        ten = 0
        for i in bills:
            if i==5:
                five+=1
            elif i==10 and five>=1:
                ten+=1
                five-=1
            elif i==20 and ten>=1 and five>=1:
                ten-=1
                five-=1
            elif i==20 and five>=3:
                five-=3
            else:
                return False
        return True
