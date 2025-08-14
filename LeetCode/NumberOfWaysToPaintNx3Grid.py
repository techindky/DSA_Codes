class Solution:
    def numOfWays(self, n: int) -> int:
        MOD = 10**9 + 7

        same_count = 6
        diff_count = 6

        for i in range(1, n):
            new_same_count = (3 * same_count + 2 * diff_count) % MOD
            new_diff_count = (2 * (same_count + diff_count)) % MOD
            same_count = new_same_count
            diff_count = new_diff_count

        total_ways = (same_count + diff_count) % MOD

        return total_ways
