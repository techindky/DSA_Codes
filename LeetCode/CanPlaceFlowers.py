class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        id1, id2 = 0, 0
        l = len(flowerbed)
        id3 = 1 if l > 1 else 0 

        while id2 < l and n > 0:
            if flowerbed[id1] == 0 and flowerbed[id2] == 0 and flowerbed[id3] == 0:
                n -= 1
                flowerbed[id2] = 1
                id2 += 2
            else: 
                id2 += 1
            id1 = id2 - 1
            if id2 + 1 < l: id3 = id2 + 1 

        return n == 0
