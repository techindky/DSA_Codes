class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:
        # Approach 1: Using bucket sort
        '''tempList = [False for _ in range(1440)]
        for i in timePoints:
            time = (int(i.split(':')[0]) * 60) + int(i.split(':')[1])
            if tempList[time]:
                return 0
            tempList[time] = True
        
        prev = -1
        minDiff = 1440
        first = -1
        last = -1
        for i in range(1440):
            if tempList[i]:
                if first==-1:
                    first = i
                if prev!=-1:
                    minDiff = min(minDiff, i - prev)
                prev = i
                last = i
        minDiff = min(minDiff, 1440 - last + first)
        return minDiff'''
        #Approach 2 : Using sorting
        tempList = []
        for i in timePoints:
            tempList.append((int(i.split(':')[0])) * 60 + int(i.split(':')[1]))
        tempList.sort()
        minDiff = 1440 - tempList[-1] + tempList[0]
        for i in range(len(tempList)-1):
            if minDiff > tempList[i+1]-tempList[i]:
                minDiff = tempList[i+1] - tempList[i]
            if minDiff==0:
                return 0
        return minDiff
