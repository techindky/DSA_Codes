class Solution:
    def diffWaysToCompute(self, expression: str) -> List[int]:
        results = []
        
        for i in range(len(expression)):
            char = expression[i]
            
            if char in "+-*":
                leftResults = self.diffWaysToCompute(expression[:i])
                rightResults = self.diffWaysToCompute(expression[i+1:])
                
                for left in leftResults:
                    for right in rightResults:
                        if char == '+':
                            results.append(left+right)
                        elif char == '*':
                            results.append(left*right)
                        else:
                            results.append(left-right)
        
        if not results:
            results.append(int(expression))
        
        return results
        
