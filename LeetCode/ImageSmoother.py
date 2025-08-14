class Solution:
    def imageSmoother(self, img: List[List[int]]) -> List[List[int]]:
        n = len(img)
        m = len(img[0])
        new = [[0 for j in range(m)] for i in range(n)]
        for i in range(n):
            for j in range(m):
                temp = img[i][j]
                neighbours = 1
                if i-1 in range(n):
                    temp+=img[i-1][j]
                    neighbours+=1
                if i+1 in range(n):
                    temp+=img[i+1][j]
                    neighbours+=1
                if j-1 in range(m):
                    temp+=img[i][j-1]
                    neighbours+=1
                if j+1 in range(m):
                    temp+=img[i][j+1]
                    neighbours+=1
                if i-1 in range(n) and j-1 in range(m):
                    temp+=img[i-1][j-1]
                    neighbours+=1
                if i-1 in range(n) and j+1 in range(m):
                    temp+=img[i-1][j+1]
                    neighbours+=1
                if i+1 in range(n) and j-1 in range(m):
                    temp+=img[i+1][j-1]
                    neighbours+=1
                if i+1 in range(n) and j+1 in range(m):
                    temp+=img[i+1][j+1]
                    neighbours+=1
                new[i][j] = temp//neighbours
        return new
