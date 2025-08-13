class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        longestCommonPrefix = ""
        flag = 0
        shortestString = len(strs[0])
        for i in strs:
            if shortestString>len(i):
                shortestString=len(i)
        for i in range(shortestString):
            commonPrefix = strs[0][i]
            for j in strs[1:]:
                if j[i]!=commonPrefix:
                    flag = 1
                    break
            if flag:
                break
            longestCommonPrefix+=commonPrefix
        return longestCommonPrefix    
                

                
