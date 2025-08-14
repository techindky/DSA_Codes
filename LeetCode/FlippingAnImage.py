class Solution:
    def flipAndInvertImage(self, image: List[List[int]]) -> List[List[int]]:
        n = len(image)
        m = len(image[0])
        for i in range(n):
            image[i].reverse()
            for j in range(m):
                if image[i][j]:
                    image[i][j] = 0
                else:
                    image[i][j] = 1
        return image
