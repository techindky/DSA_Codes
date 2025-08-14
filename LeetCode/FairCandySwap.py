class Solution:
    def fairCandySwap(self, aliceSizes: List[int], bobSizes: List[int]) -> List[int]:
        totalBobsCandy = sum(bobSizes)
        totalAliceCandy = sum(aliceSizes)
        required = (totalAliceCandy-totalBobsCandy)//2
        bob_set = set(bobSizes)

        for i in aliceSizes:
            b = i - required
            if b in bob_set:
                return [i,b]
