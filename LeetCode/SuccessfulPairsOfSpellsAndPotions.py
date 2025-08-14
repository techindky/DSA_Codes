class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        result = []
        potions.sort()
        for i in spells:
            min_value = (success + i - 1)//i
            idx = bisect.bisect_left(potions, min_value)
            result.append(len(potions)-idx)
        return result 
            
