import collections
import bisect
class FenwickTree:
    def __init__(self, size):
        self.tree = [0] * (size + 1)
        self.size = size

    def update(self, index, delta):
        index += 1
        while index <= self.size:
            self.tree[index] += delta
            index += index & (-index)

    def query(self, index):
        index +=1
        s = 0
        while index > 0:
            s += self.tree[index]
            index -= index & (-index)
        return s

    def query_range(self, left, right):
        if left > right:
            return 0
        return self.query(right) - self.query(left - 1)
class Solution:
    def perfectPairs(self, nums: List[int]) -> int:
        temp = nums
        n = len(temp)
        count = 0

        value_set = set()
        for x in temp:
            value_set.add(abs(x))

        sorted_values = sorted(list(value_set))
        rank_map = {val: i for i, val in enumerate(sorted_values)}
        max_rank = len(sorted_values)

        ft = FenwickTree(max_rank)
        for i in range(n):
            current_val = abs(temp[i])
            lower_bound_val = (current_val + 1) // 2 if current_val != 0 else 0
            upper_bound_val = 2 * current_val
            low_idx = bisect.bisect_left(sorted_values, lower_bound_val)
            upper_idx = bisect.bisect_right(sorted_values, upper_bound_val) - 1
            count += ft.query_range(low_idx, upper_idx)
            ft.update(rank_map[current_val], 1)

        return count
