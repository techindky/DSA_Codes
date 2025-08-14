class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        h ={}
        stack = []
        n = len(nums1)
        m = len(nums2)
        for i in range(m):
            if len(stack) == 0:
                stack.append(nums2[i])
                continue
            if nums2[i] > stack[-1]:
                n = stack.pop()
                while n < nums2[i]:
                    h[n] = nums2[i]
                    if len(stack) > 0 and stack[-1] < nums2[i]:
                        n = stack.pop()
                    else:
                        break
                stack.append(nums2[i])
            else:
                stack.append(nums2[i])
        ans = []
        for i in nums1:
            if i in h:
                ans.append(h[i])
            else:
                ans.append(-1)
        return ans
        
        
