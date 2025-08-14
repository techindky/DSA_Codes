from itertools import combinations
class Solution:
    def largestTriangleArea(self, points: List[List[int]]) -> float:
        def calculate_area(x1, y1, x2, y2, x3, y3):
            return abs(x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2)) / 2.0
    
        def convex_hull(points):
            points = sorted(points)
            if len(points) <= 1:
                return points
            
            def cross(o, a, b):
                return (a[0] - o[0]) * (b[1] - o[1]) - (a[1] - o[1]) * (b[0] - o[0])
            
            lower = []
            for p in points:
                while len(lower) >= 2 and cross(lower[-2], lower[-1], p) <= 0:
                    lower.pop()
                lower.append(p)
            
            upper = []
            for p in reversed(points):
                while len(upper) >= 2 and cross(upper[-2], upper[-1], p) <= 0:
                    upper.pop()
                upper.append(p)
            
            return lower[:-1] + upper[:-1]
          
        hull = convex_hull(points)
        n = len(hull)
        max_area = 0.0

        for i in range(n):
            for j in range(i + 1, n):
                x1, y1 = hull[i]
                x2, y2 = hull[j]
                
                current_area = 0.0
                for k in range(n):
                    x3, y3 = hull[k]
                    current_area = max(current_area, calculate_area(x1, y1, x2, y2, x3, y3))
                max_area = max(max_area, current_area)
        
        return max_area
