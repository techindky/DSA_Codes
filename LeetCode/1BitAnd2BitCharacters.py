class Solution:
    def isOneBitCharacter(self, bits: List[int]) -> bool:
        if len(bits)==1:
            return True
        lastBit = 1
        i = 0
        while(i<len(bits)):
            if bits[i]==1 and (bits[i+1]==0 or bits[i+1]==1):
                i+=1
                lastBit = 2
            else:
                lastBit = 1
            i+=1
        return lastBit==1
        
