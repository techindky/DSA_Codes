class Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        runningSum = 0
        result = 0
        for i in range(len(arr)):
            runningSum += arr[i]
            if runningSum == (i*(i+1))//2:
                result += 1
        return result
