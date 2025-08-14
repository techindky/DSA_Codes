class Solution:
    def reverseVowels(self, s: str) -> str:
        low = 0
        high = len(s) - 1
        string = list(s)
        vowels = set(['a','A','e','E','I','i','O','o','U','u'])
        while (low <= high):
            if string[low] in vowels and string[high] in vowels:
                string[low],string[high] = string[high],string[low]
                low+=1
                high-=1
            elif string[low] in vowels:
                high-=1
            elif string[high] in vowels:
                low+=1
            else:
                low+=1
                high-=1
        
        return ''.join(string)
