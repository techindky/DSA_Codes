class Solution:
    def findWords(self, words: List[str]) -> List[str]:
        firstrow = "qwertyuiopQWERTYUIOP"
        secondrow = "asdfghjklASDFGHJKL"
        thirdrow = "zxcvbnmZXCVBNM"
        result = []
        for i in words:
            found = True
            for j in i:
                if j not in firstrow:
                    found = False
                    break
            if found:
                print(1)
                result.append(i)
                continue
            found = True
            for j in i:
                if j not in secondrow:
                    found = False
                    break
            if found:
                print(2)
                result.append(i)
                continue
            found = True
            for j in i:
                if j not in thirdrow:
                    found = False
                    break
            if found:
                print(3)
                result.append(i)
        return result
