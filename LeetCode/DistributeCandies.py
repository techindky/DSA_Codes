class Solution:
    def distributeCandies(self, candyType: List[int]) -> int:
        n = len(candyType)
        candyTypeSet = set(candyType)
        max_types = min(len(candyTypeSet), n // 2)
        return max_types
