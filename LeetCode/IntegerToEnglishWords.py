class Solution:
    def numberToWords(self, num: int) -> str:
        if num==0:
            return "Zero"
        m = {1:"One",2:"Two",3:"Three",4:"Four",5:"Five",6:"Six",7:"Seven",8:"Eight",9:"Nine",10:"Ten",11:"Eleven",12:"Twelve",13:"Thirteen",14:"Fourteen",15:"Fifteen",16:"Sixteen",17:"Seventeen",18:"Eighteen",19:"Nineteen",20:"Twenty",30:"Thirty",40:"Forty",50:"Fifty",60:"Sixty",70:"Seventy",80:"Eighty",90:"Ninety"}
        result = []
        def helper(s):
            string = ""
            temp = s//100
            if(temp > 0):
                string += m[temp] + " Hundred "
            s = s%100
            if s == 0:
                pass
            elif s <= 20:
                string += m[s] + " "
            elif s % 10 == 0:
                string += m[s] + " "
            else:
                temp = s%10
                s -= temp
                string += m[s] + " "
                string += m[temp] + " "
            return string.strip()
        billion = num // 1000000000
        million = (num % 1000000000) // 1000000
        thousand = (num % 1000000) // 1000
        remainder = num % 1000
        
        if billion > 0:
            result.append(helper(billion) + " Billion")
        if million > 0:
            result.append(helper(million) + " Million")
        if thousand > 0:
            result.append(helper(thousand) + " Thousand")
        if remainder > 0:
            result.append(helper(remainder))
        return (" ".join(result)).strip()




        
        
