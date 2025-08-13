class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        mergedArray = (nums1+nums2)
        mergedArray.sort()
        n = len(mergedArray)
        if n%2==0:
            return (mergedArray[n//2]+mergedArray[(n//2)-1])/2
        else:
            return mergedArray[n//2]
