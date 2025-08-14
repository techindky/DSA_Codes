import heapq
from typing import List

class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        graph = {i: [] for i in range(1, n + 1)}
        for u, v, w in times:
            graph[u].append((v, w))
          
        heap = [(0, k)]
        dist = {i: float('inf') for i in range(1, n + 1)}
        dist[k] = 0
        
        while heap:
            time, node = heapq.heappop(heap)
            if time > dist[node]:
                continue
            for nei, w in graph[node]:
                if dist[nei] > time + w:
                    dist[nei] = time + w
                    heapq.heappush(heap, (dist[nei], nei))
        
        max_time = max(dist.values())
        return max_time if max_time < float('inf') else -1
