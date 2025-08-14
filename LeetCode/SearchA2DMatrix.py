class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        st = 0
        ed = len(matrix)-1
        md = (st+ed)//2
        while(st<=ed):
            if target<=matrix[md][len(matrix[md])-1] and target>=matrix[md][0]:
                break
            elif target>matrix[md][len(matrix[md])-1]:
                st = md + 1
            else:
                ed = md - 1
            md = (st+ed)//2
        s = 0
        e = len(matrix[md])-1
        m = (s+e)//2
        while(s<=e):
            if matrix[md][m]==target:
                return True
            elif matrix[md][m]>target:
                e = m - 1
            else:
                s = m + 1
            m = (s+e)//2
        return False
