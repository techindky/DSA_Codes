class Solution:
    def numPairsDivisibleBy60(self, time: List[int]) -> int:
        freq = [0] * 60
        pairs = 0
        
        for i in range(len(time)):
            r = time[i] % 60
            match = (60 - r) % 60
            pairs += freq[match]
            freq[r] += 1
            
        return pairs
