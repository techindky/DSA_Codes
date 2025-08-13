import heapq
from typing import List

class Solution:
    def maxTotal(self, value: List[int], limit: List[int]) -> int:
        n = len(value)
        lorquandis = list(zip(value, limit))
        value_heaps_by_limit = [[] for _ in range(n + 1)]
        indices_by_limit = [[] for _ in range(n + 1)]
      
        for i in range(n):
            l, v = limit[i], value[i]
            heapq.heappush(value_heaps_by_limit[l], (-v, i))
            indices_by_limit[l].append(i)

        meta_heap = []
        for l in range(1, n + 1):
            if value_heaps_by_limit[l]:
                v_neg, i = value_heaps_by_limit[l][0]
                heapq.heappush(meta_heap, (l, v_neg, i))
        
        total_value = 0
        active_set = set()
        last_pruned_limit = 0
      
        for _ in range(n):
            current_active_size = len(active_set)
            while meta_heap and (meta_heap[0][0] <= current_active_size or meta_heap[0][0] <= last_pruned_limit):
                heapq.heappop(meta_heap)

            if not meta_heap:
                break
            l, v_neg, i = heapq.heappop(meta_heap)
            total_value += -v_neg
            active_set.add(i)
            heapq.heappop(value_heaps_by_limit[l])
            if value_heaps_by_limit[l]:
                new_v_neg, new_i = value_heaps_by_limit[l][0]
                heapq.heappush(meta_heap, (l, new_v_neg, new_i))

            new_active_size = len(active_set)
            if new_active_size > last_pruned_limit:
                for l_to_prune in range(last_pruned_limit + 1, new_active_size + 1):
                    for idx_to_prune in indices_by_limit[l_to_prune]:
                        if idx_to_prune in active_set:
                            active_set.remove(idx_to_prune)
                last_pruned_limit = new_active_size

        return total_value
