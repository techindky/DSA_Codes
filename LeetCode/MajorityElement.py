class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        count = 0
        candidate = -1
        
        for i in nums:
            if count == 0:
                candidate = i
                count = 1
            elif candidate == i:
                count += 1
            else:
                count -= 1
        
        return candidate
