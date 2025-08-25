class Solution:
    def partitionArray(self, nums: List[int], k: int) -> bool:
        n = len(nums)
        if n % k != 0:
            return False
        g = n // k;
        freq = Counter(nums)
        return max(freq.values()) <= g;
