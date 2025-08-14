class Solution:
    def minDays(self, bloomDay: List[int], m: int, k: int) -> int:
        n = len(bloomDay)
        if k*m > n:
            return -1
        elif k==1:
            bloomDay.sort()
            return bloomDay[m-1]
        elif k*m == n:
            return max(bloomDay)
        start = min(bloomDay)
        end = max(bloomDay)
        while(start<end):
            mid = (start+end)//2
            bou = 0
            flo = 0
            for i in bloomDay:
                if i <= mid:
                    flo+=1
                    if flo==k:
                        bou+=1
                        flo = 0
                else:
                    flo = 0 
            if bou >= m:
                end = mid
            else:
                start = mid +1
            print(start)   
        return start
        
