class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        result = []
        n = len(nums)
        if n==0:
            return []
        a = nums[0]
        b = nums[0]
        for i in range(1,n+1):
            if i==n:
                if a==b:
                    result.append("{}".format(a))
                else:
                    result.append("{}->{}".format(a,b))
                break
            if nums[i]!=nums[i-1]+1:
                if a==b:
                    result.append("{}".format(a))
                else:
                    result.append("{}->{}".format(a,b))
                a = nums[i]
                b = nums[i]
            else:
                b+=1
                
        return result
            
