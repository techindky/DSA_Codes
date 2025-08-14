class Solution:
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        start = 0
        end = len(letters)-1
        if letters[-1] <= target:
            return letters[0]
        smallest = letters[-1]
        while(start <= end):
            mid = (start+end)//2
            if letters[mid] > target and letters[mid] < smallest: 
                smallest = letters[mid]
                end = mid - 1
            elif letters[mid] <= target:
                start = mid + 1
            else:
                end = mid - 1
        return smallest
