class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        dp = {}
        ds = {}
        for i in range(len(pattern)):
            if pattern[i] in dp:
                dp[pattern[i]].append(i)
            else:
                dp[pattern[i]] = [i]
        l = s.split()
        for i in range(len(l)):
            if l[i] in ds:
                ds[l[i]].append(i)
            else:
                ds[l[i]] = [i]
        return list(dp.values())==list(ds.values())
