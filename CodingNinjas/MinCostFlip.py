from typing import List

def min_cost_flip(n: int, a: List[int], b: List[int]) -> int:
    left_zeros = [0] * n
    if n > 0 and b[0] == 0:
        left_zeros[0] = 1
    for i in range(1, n):
        if b[i] == 0:
            left_zeros[i] = left_zeros[i - 1] + 1
    right_zeros = [0] * n
    if n > 0 and b[n - 1] == 0:
        right_zeros[n - 1] = 1
    for i in range(n - 2, -1, -1):
        if b[i] == 0:
            right_zeros[i] = right_zeros[i + 1] + 1
    max_beauty_no_flip = 0
    if any(val == 0 for val in b):
        max_beauty_no_flip = max(left_zeros) if left_zeros else 0

    flip_options = {}
    for i in range(n):
        if b[i] == 1:
            cost = a[i]
            
            left_count = left_zeros[i - 1] if i > 0 else 0
            right_count = right_zeros[i + 1] if i < n - 1 else 0
            
            new_beauty = left_count + 1 + right_count

            if new_beauty not in flip_options:
                flip_options[new_beauty] = cost
            else:
                flip_options[new_beauty] = min(flip_options[new_beauty], cost)

    max_beauty = max_beauty_no_flip
    if flip_options:
        max_beauty = max(max_beauty, max(flip_options.keys()))

    cost_no_flip = float('inf')
    if max_beauty == max_beauty_no_flip:
        cost_no_flip = 0

    cost_with_flip = float('inf')
    if max_beauty in flip_options:
        cost_with_flip = flip_options[max_beauty]

    min_final_cost = min(cost_no_flip, cost_with_flip)

    return min_final_cost

