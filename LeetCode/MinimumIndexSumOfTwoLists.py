class Solution:
    def findRestaurant(self, list1: List[str], list2: List[str]) -> List[str]:
        n = len(list1)
        m = len(list2)
        result = []
        d = {}
        for i in range(m):
            if list2[i] in list1:
                d[list2[i]] = i
        for i in range(n):
            if list1[i] in d:
                d[list1[i]] += i
        minIndex = n+m
        for i in list1:
            if i in d:
                minIndex = min(minIndex, d[i])
        for key,value in d.items():
            if value == minIndex:
                result.append(key)
        return result
        
        
