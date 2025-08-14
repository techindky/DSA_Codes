class Solution:
    def minimumLength(self, s: str) -> int:
        if len(s) < 3:
            return len(s)
        frequency = {}
        for i in s:
            frequency[i] = frequency.get(i, 0) + 1
        remaining = True
        while remaining:
            remaining = False
            for key,value in frequency.items():
                if value > 2:
                    remaining = True
                    frequency[key] = value - 2
        return sum(frequency.values())
