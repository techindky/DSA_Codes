class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        rows = len(matrix)
        cols = len(matrix[0])
        result = []
        startingRow = 0
        startingCol = 0
        endingRow = rows-1
        endingCol = cols-1
        while(True):
          
            for j in range(startingCol,endingCol+1):
                result.append(matrix[startingRow][j])
            startingRow+=1
          
            if len(result)==rows*cols:
                break
              
            for j in range(startingRow,endingRow+1):
                result.append(matrix[j][endingCol])
            endingCol-=1
          
            if len(result)==rows*cols:
                break
              
            for j in range(endingCol,startingCol-1,-1):
                result.append(matrix[endingRow][j])
            endingRow-=1
          
            if len(result)==rows*cols:
                break
              
            for j in range(endingRow,startingRow-1,-1):
                result.append(matrix[j][startingCol])
            startingCol+=1
          
            if len(result)==rows*cols:
                break
              
        return result
