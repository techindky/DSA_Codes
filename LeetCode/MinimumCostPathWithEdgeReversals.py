import heapq
from collections import defaultdict
class Solution:
    def minCost(self, n: int, edges: List[List[int]]) -> int:
        gf = defaultdict(list)
        gr = defaultdict(list)

        for u, v, w in edges:
            gf[u].append((v,w))
            gr[v].append((u,w))

        dis = [float('inf')] * n
        pq = [(0,0)]
        

        while pq:
            cost, node = heapq.heappop(pq)
            if cost > dis[node]:
                continue

            if node == n -1:
                return cost

            for tn, w in gf[node]:
                new_cost = cost + w
                if new_cost < dis[tn]:
                    dis[tn] = new_cost
                    heapq.heappush(pq, (new_cost, tn))
            for pn, w in gr[node]:
                new_cost = cost + (2 * w)
                
                if new_cost < dis[pn]:
                    dis[pn] = new_cost
                    heapq.heappush(pq, (new_cost, pn))
        return -1
