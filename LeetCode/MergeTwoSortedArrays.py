class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        i,j = m-1,n-1
        last_index = m + n - 1
        while j >= 0:
            if i >= 0 and nums1[i] > nums2[j]:
                nums1[last_index] = nums1[i]
                i -= 1
            else:
                nums1[last_index] = nums2[j]
                j -= 1
            last_index -= 1
        return nums1
        
