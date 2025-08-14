class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        hasCarry = False
        for i in range(len(digits) - 1, -1, -1):
            if digits[i] < 9:
                digits[i] += 1
                hasCarry = False
                break
            else:
                digits[i] = 0
                hasCarry = True
        return [1] + digits if hasCarry else digits
