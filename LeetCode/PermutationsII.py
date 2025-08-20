class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        if len(nums) == 1:
            return [nums[:]]
        
        res = set()

        for _ in range(len(nums)):
            n = nums.pop(0)
            perms = self.permuteUnique(nums)

            for p in perms:
                p.append(n)
                res.add(tuple(p))

            nums.append(n)
        
        return [list(p) for p in res]
