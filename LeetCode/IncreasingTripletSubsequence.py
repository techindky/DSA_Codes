class Solution:
    def increasingTriplet(self, nums: List[int]) -> bool:
        first_min = 2147483647
        second_min = 2147483647
        for num in nums:
            if num <= first_min:
                first_min = num
            elif num <= second_min:
                second_min = num
            else:
                return True
        
        return False
