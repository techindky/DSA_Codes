class Solution:
    def minArraySum(self, nums: List[int], k: int) -> int:
        n = len(nums)
        dp = [0] * (n+1)
        min_dp_rem = {0: 0}
        current_ps = 0
        for i in range(1,n+1):
            current_ps += nums[i-1]
            current_rem = current_ps % k
            dp[i] = dp[i-1] + nums[i-1]
            if current_rem in min_dp_rem:
                dp[i] = min(dp[i], min_dp_rem[current_rem])
            if current_rem not in min_dp_rem:
                min_dp_rem[current_rem] = dp[i]
            else:
                min_dp_rem[current_rem] = min(min_dp_rem[current_rem], dp[i])

        return dp[n]
