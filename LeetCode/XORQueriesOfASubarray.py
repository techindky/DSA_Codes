class Solution:
    def xorQueries(self, arr: List[int], queries: List[List[int]]) -> List[int]:
        prefix = []
        prefix.append(arr[0])
        for i in range(1,len(arr)):
            prefix.append(prefix[i-1]^arr[i])
        result = []
        for i in queries:
            if i[0]==0:
                result.append(prefix[i[1]])
            else:
                result.append(prefix[i[1]]^prefix[i[0]-1])
        return result
