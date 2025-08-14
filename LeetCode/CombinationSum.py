class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        def backtrack(current_combination, start_index, remaining_target):
            if remaining_target == 0:
                result.append(list(current_combination))
                return
            if remaining_target < 0:
                return

            for i in range(start_index, len(candidates)):
                candidate = candidates[i]
                current_combination.append(candidate)
                backtrack(current_combination, i, remaining_target - candidate)
                current_combination.pop()
    
        result = []
        backtrack([], 0, target)
        return result
