class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        d = {}
        for i in arr:
            if i not in d.keys():
                d[i] = 1
            else:
                d[i] = d[i]+1
        if len(set(d.values()))==len(d.values()):
            return True
        else:
            return False
