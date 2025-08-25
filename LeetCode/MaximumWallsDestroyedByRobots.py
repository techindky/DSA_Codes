class Solution:
    def maxWalls(self, robots: List[int], distance: List[int], walls: List[int]) -> int:
        n = len(robots)
        robots = sorted(zip(robots, distance))
        pos = [p for p, _ in robots]
        dist = [d for _, d in robots]
        walls.sort()

        left_cover = [set() for _ in range(n)]
        right_cover = [set() for _ in range(n)]

        for i in range(n):
            p, d = pos[i], dist[i]

            left_limit = p - d
            if i > 0:
                left_limit = max(left_limit, pos[i-1] + 1)
            li = bisect_left(walls, left_limit)
            ri = bisect_right(walls, p)
            left_cover[i] = set(walls[li:ri])

            right_limit = p + d
            if i < n - 1:
                right_limit = min(right_limit, pos[i+1] - 1)
            li = bisect_left(walls, p)
            ri = bisect_right(walls, right_limit)
            right_cover[i] = set(walls[li:ri])

        dp = [[-1] * 2 for _ in range(n)]
        dp[0][0] = len(left_cover[0])
        dp[0][1] = len(right_cover[0])

        for i in range(1, n):
            for d1 in [0, 1]:
                if dp[i-1][d1] == -1:
                    continue
                prev_set = left_cover[i-1] if d1 == 0 else right_cover[i-1]
                for d2 in [0, 1]:
                    cur_set = left_cover[i] if d2 == 0 else right_cover[i]
                    gain = len(cur_set - prev_set)
                    dp[i][d2] = max(dp[i][d2], dp[i-1][d1] + gain)

        return max(dp[n-1][0], dp[n-1][1])
