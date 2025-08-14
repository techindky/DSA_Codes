class Solution:
    def peakIndexInMountainArray(self, arr: List[int]) -> int:
        n = len(arr)
        start = 0
        end = n - 1
        mid = start + (end - start)//2
        while(start<=end):
            if arr[mid]>arr[mid-1] and arr[mid]>arr[mid+1]:
                return mid
            elif arr[mid]<arr[mid-1]:
                end = mid - 1
            else:
                start = mid + 1
            mid = start + (end - start)//2
            if mid==0:
              return mid+1
            elif mid==n-1:
              return mid-1
        
