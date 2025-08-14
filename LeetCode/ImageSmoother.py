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

'''
Approach : Bit Manipulation
class Solution:
    def imageSmoother(self, img: List[List[int]]) -> List[List[int]]:
        # Save the dimensions of the image.
        m = len(img)
        n = len(img[0])

        # Iterate over the cells of the image.
        for i in range(m):
            for j in range(n):
                # Initialize the sum and count 
                sum = 0
                count = 0

                # Iterate over all plausible nine indices.
                for x in (i - 1, i, i + 1):
                    for y in (j - 1, j, j + 1):
                        # If the indices form valid neighbor
                        if 0 <= x < m and 0 <= y < n:
                            # Extract the original value of img[x][y].
                            sum += img[x][y] & 255
                            count += 1
                
                # Encode the smoothed value in img[i][j].
                img[i][j] |= (sum // count) << 8
        
        # Extract the smoothed value from encoded img[i][j].
        for i in range(m):
            for j in range(n):
                img[i][j] >>= 8
            
        # Return the smooth image.
        return img
'''
