class Solution:
    def romanToInt(self, s: str) -> int:
        no = 0
        roman_list = [['M',1000],['CM',900],['D',500],['CD',400],['C',100],['XC',90],['L',50],['XL',40],['X',10],['IX',9],['V',5],['IV',4],['I',1]]
        i=0
        while(i<len(s)):
            for j in roman_list:
                if s[i:i+2]==j[0]:
                    i+=2
                    no+=j[1]
                    break
                elif s[i]==j[0]:
                    no+=j[1]
                    i+=1
                    break
            print(no)
        return no
