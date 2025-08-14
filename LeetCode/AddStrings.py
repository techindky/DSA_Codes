class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        number1 = 0
        n = len(num1)
        for i in range(n):
            number1 += int(num1[i])*pow(10, n - i - 1)
        number2 = 0
        m = len(num2)
        for i in range(m):
            number2 += int(num2[i])*pow(10, m - i - 1)
        result = number1 + number2
        if result==0:
            return "0"
        ans = ""
        while(result > 0):
            ans = str(result%10) + ans
            result = result // 10
        return ans
