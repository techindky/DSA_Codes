class Solution:
    def canBeEqual(self, target: List[int], arr: List[int]) -> bool:
        if set(target)!=set(arr):
            return False
        dt = {}
        da = {}
        for i in target:
            dt[i] = dt.get(i, 0) + 1
        for i in arr:
            da[i] = da.get(i, 0) + 1
        for key in dt:
            if dt[key] != da[key]:
                return False
        return True
