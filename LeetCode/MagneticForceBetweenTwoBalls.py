class Solution:
    def maxDistance(self, position: List[int], m: int) -> int:
        n = len(position)
        position.sort()
        if m==2:
            return position[n-1]-position[0]
        start = 1
        end = position[n-1]
        while(start<=end):
            mid = (start + end)//2
            last_pos = position[0]
            bal = 1
            for i in position:
                if i - last_pos >= mid:
                    bal+=1
                    last_pos = i
                    if bal==m:
                        break
            if bal==m:
                start = mid + 1
            else:
                end = mid - 1
        return end
