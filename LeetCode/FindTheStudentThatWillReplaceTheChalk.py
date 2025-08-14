class Solution:
    def chalkReplacer(self, chalk: List[int], k: int) -> int:
        remainder = k%sum(chalk)
        for i in range(len(chalk)):
            if remainder < chalk[i]:
                return i
            remainder -= chalk[i]
