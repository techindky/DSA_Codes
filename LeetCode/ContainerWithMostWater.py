class Solution:
    def maxArea(self, height: List[int]) -> int:
        maxArea = 0
        n = len(height)
        left = 0
        right = n-1
        while(left<right):
            t = min(height[left],height[right])
            maxArea = max(maxArea,t*(right-left))
            if height[left]<height[right]:
                left+=1
            elif height[left]>height[right]:
                right-=1
            else:
                left+=1
                right-=1
        return maxArea
