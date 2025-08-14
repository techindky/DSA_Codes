class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        nthRow = [1]
        for i in range(1,rowIndex+1):
            nthRow.append(nthRow[-1]*(rowIndex-i+1)//i)
        return nthRow
            
