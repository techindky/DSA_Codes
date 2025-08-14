class Solution:
    def secondGreaterElement(self, nums: List[int]) -> List[int]:
        n = len(nums)
        ans = [-1] * n
        stack = []
        for i in range(len(nums)):
            res=[]
            while stack and nums[stack[-1][0]]<nums[i]:
                t=stack.pop()
                if t[1] == 1:
                    ans[t[0]]=nums[i]
                else:
                    t[1]+=1
                    res.append(t)
            stack.append([i,0])
            stack+=res[::-1]
        return ans

                
