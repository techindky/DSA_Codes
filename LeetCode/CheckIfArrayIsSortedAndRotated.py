class Solution:
    def check(self, nums: List[int]) -> bool:
        #Approach 1
        n = len(nums)
        ar = sorted(nums)
        x = 0
        if nums == ar:
            return True
        for i in range(1,n):
            if nums[i]==ar[0] and nums[i-1]==ar[n-1]:
                x = i
                break
        ar = ar[-x:]+ar[:-x]
        for i in range(n):
            if nums[i]!=ar[i]:
                return False
        return True
        #Approach 2
        '''for i in range(n):
            if i==n-1:
                if nums[i]>nums[0]:
                    return False
            elif nums[i]>nums[i+1] and nums[i]!=ar[n-1]:
                return False
        return True'''
        #Approach 3
        '''count = 0
        for i in range(1, len(nums)):
            if nums[i] < nums[i - 1]:
                count += 1

        if nums[-1] > nums[0]:
            count += 1

        return count <= 1'''
