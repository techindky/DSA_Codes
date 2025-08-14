class Solution:
    def findShortestSubArray(self, nums: List[int]) -> int:
        n = len(nums)
        freq = Counter(nums)
        maxFreq = max(freq.values())
        if maxFreq == 1:
            return 1
        mostlyOccurred = []
        for key, value in freq.items():
            if value == maxFreq:
                mostlyOccurred.append(key)
        minLength = n
        for i in mostlyOccurred:
            start = 0
            end = 0
            for j in range(n):
                if nums[j]==i:
                    start = j
                    break
            for j in range(n-1,-1,-1):
                if nums[j]==i:
                    end = j
                    break
            minLength = min((end-start)+1,minLength)
        return minLength
