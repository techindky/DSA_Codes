class Solution:
    def minKBitFlips(self, nums: List[int], k: int) -> int:
        n = len(nums)
        check = [0] * (n+1)
        flipCount = 0
        currentFlip = 0

        for i in range(n):
            currentFlip ^= check[i]
            if nums[i] == currentFlip%2:
                if i+k>n:
                    return -1
                flipCount+=1
                currentFlip^=1
                print(currentFlip)
                check[i+k] ^= 1
        return flipCount
