class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        n = len(digits)
        result = []
        if n==0:
            return result
        mapping = {'2':['a','b','c'],'3':['d','e','f'],'4':['g','h','i'],'5':['j','k','l'],
        '6':['m','n','o'],'7':['p','q','r','s'],'8':['t','u','v'],'9':['w','x','y','z']}
        if n == 1:
            return mapping[digits[0]]
        elif n == 2:
            for i in mapping[digits[0]]:
                for j in mapping[digits[1]]:
                    result.append(i+j)
        elif n == 3:
            for i in mapping[digits[0]]:
                for j in mapping[digits[1]]:
                    for k in mapping[digits[2]]:
                        result.append(i+j+k)
        else:
            for i in mapping[digits[0]]:
                for j in mapping[digits[1]]:
                    for k in mapping[digits[2]]:
                        for l in mapping[digits[3]]:
                            result.append(i+j+k+l)
        return result
