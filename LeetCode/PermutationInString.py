class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        #Approach 1 using dictionary or hashmap
        '''d = {}
        for i in s1:
            d[i] = d.get(i,0)+1
        for i in range(len(s2)-len(s1)+1):
            d1 = {}
            for j in s2[i:i+len(s1)]:
                d1[j] = d1.get(j,0)+1
            if d==d1:
                return True        
        return False'''
        #Approach 2 using counter
        '''ln = len(s1)
        mp1 = collections.Counter(s1)
        for i in range(len(s2) - ln + 1):
            sb = s2[i:i+ln]
            if mp1 == collections.Counter(sb):
                return True
        return False'''
        #Approach 3 using Sliding window
        cntr, w, match = Counter(s1), len(s1), 0     

        for i in range(len(s2)):
            if s2[i] in cntr:
                if not cntr[s2[i]]: match -= 1
                cntr[s2[i]] -= 1
                if not cntr[s2[i]]: match += 1

            if i >= w and s2[i-w] in cntr:
                if not cntr[s2[i-w]]: match -= 1
                cntr[s2[i-w]] += 1
                if not cntr[s2[i-w]]: match += 1

            if match == len(cntr):
                return True

        return False
