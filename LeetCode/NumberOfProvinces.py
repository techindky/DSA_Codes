class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n = len(isConnected)
        visited = [False] * n
        count = 0

        def dfs(city):
            stack = [city]
            while stack:
                current = stack.pop()
                for neighbor in range(n):
                    if isConnected[current][neighbor] == 1 and not visited[neighbor]:
                        visited[neighbor] = True
                        stack.append(neighbor)

        for city in range(n):
            if not visited[city]:
                dfs(city)
                count += 1

        return count
