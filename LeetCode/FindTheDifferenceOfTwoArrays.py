class Solution:
    def findDifference(self, nums1: List[int], nums2: List[int]) -> List[List[int]]:
        s = set(nums1)
        s2 = set(nums2)
        return [list(s-s2), list(s2-s)]
