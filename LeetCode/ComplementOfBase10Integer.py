class Solution:
    def bitwiseComplement(self, n: int) -> int:
        b = bin(n).replace("0b","")
        c = ""
        for i in b:
            if i=='1':
                c=c+"0"
            else:
                c=c+"1"
        decimal = 0
        for j in range(len(c)):
            if c[len(c)-j-1]=='1':
                decimal+=pow(2,j)
        return decimal

        
