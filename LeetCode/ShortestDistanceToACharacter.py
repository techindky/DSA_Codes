class Solution:
    def shortestToChar(self, s: str, c: str) -> List[int]:
        n = len(s)
        answer = [float('inf')] * n

        prev_position = -float('inf')
        for i in range(n):
            if s[i] == c:
                prev_position = i
            answer[i] = abs(i - prev_position)

        prev_position = float('inf')
        for i in range(n - 1, -1, -1):
            if s[i] == c:
                prev_position = i
            answer[i] = min(answer[i], abs(i - prev_position))

        return answer
