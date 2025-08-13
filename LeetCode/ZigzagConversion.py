class Solution:
    def convert(self, s: str, numRows: int) -> str:
        n = len(s)
        if numRows == 1 or numRows==n:
            return s
        l = ["" for _ in range(numRows)]
        temp = 0
        directional = 1
        for i in s:
            l[temp]+=i
            if temp==0:
                directional = 1
            elif temp==numRows-1:
                directional = -1
            temp+=directional
        result = ""
        for i in l:
            result+=i
        return result

        

        
