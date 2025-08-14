class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        return [self.search(nums, target, True), self.search(nums, target, False)]

    def search(self, nums: List[int], target: int, isFirst: bool) -> int:
        low = 0
        high = len(nums) - 1
        ans = -1
        while low <= high:
            mid = (low + high) // 2
            if isFirst:
                if nums[mid] < target:
                    low = mid + 1
                else:
                    high = mid - 1
            else:
                if nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1

            if nums[mid] == target:
                ans = mid
        return ans
