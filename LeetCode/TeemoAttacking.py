class Solution:
    def findPoisonedDuration(self, timeSeries: List[int], duration: int) -> int:
        totalDuration = 0
        start, end = 0,0
        for i in timeSeries:
            if i in range(start,end):
                totalDuration-=end-i
            start, end = i, i+duration
            totalDuration += end-start
        return totalDuration
