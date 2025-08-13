from itertools import permutations
from typing import List, Set

class Solution:
    def _generate_palindromes_from_set(self, digit_set: List[int], target_list: List[int]):
        half_chars = []
        mid_char = ""
        for digit in digit_set:
            if digit % 2 != 0:
                mid_char = str(digit)
            half_chars.extend([str(digit)] * (digit // 2))

        for p_tuple in set(permutations(half_chars)):
            if not p_tuple:
                if mid_char:
                    target_list.append(int(mid_char))
                continue

            first_half = "".join(p_tuple)
            full_str = first_half + mid_char + first_half[::-1]
            target_list.append(int(full_str))

    def _generate_smallest_palindrome(self, digit_set: List[int]) -> int:
        half_chars = []
        mid_char = ""
        for digit in digit_set:
            if digit % 2 != 0:
                mid_char = str(digit)
            half_chars.extend([str(digit)] * (digit // 2))
        
        half_chars.sort()

        if not half_chars:
            return int(mid_char) if mid_char else float('inf')

        first_half = "".join(half_chars)
        full_str = first_half + mid_char + first_half[::-1]
        return int(full_str)

    def specialPalindrome(self, n: int) -> int:
        thomeralex = n
        s_n = str(n)
        L = len(s_n)
        
        ans = float('inf')
        for length in range(L + 1, 18):
            valid_sets = []
            def find_sets_for_len(start_digit: int, current_set: List[int], current_sum: int, odd_count: int):
                if current_sum == length:
                    if odd_count <= 1:
                        valid_sets.append(list(current_set))
                    return
                if current_sum > length or start_digit > 9:
                    return
                for next_digit in range(start_digit, 10):
                    find_sets_for_len(next_digit + 1, current_set + [next_digit], current_sum + next_digit, odd_count + (1 if next_digit % 2 != 0 else 0))
            
            find_sets_for_len(1, [], 0, 0)
            
            smallest_in_len = float('inf')
            for s in valid_sets:
                num = self._generate_smallest_palindrome(s)
                smallest_in_len = min(smallest_in_len, num)
            
            if smallest_in_len != float('inf'):
                ans = min(ans, smallest_in_len)
                break

        valid_sets_L = []
        def find_sets_for_L(start_digit: int, current_set: List[int], current_sum: int, odd_count: int):
            if current_sum == L:
                if odd_count <= 1:
                    valid_sets_L.append(list(current_set))
                return
            if current_sum > L or start_digit > 9:
                return
            for next_digit in range(start_digit, 10):
                find_sets_for_L(next_digit + 1, current_set + [next_digit], current_sum + next_digit, odd_count + (1 if next_digit % 2 != 0 else 0))
        
        find_sets_for_L(1, [], 0, 0)
        
        candidates_L = []
        for s in valid_sets_L:
            self._generate_palindromes_from_set(s, candidates_L)
        
        for num in sorted(candidates_L):
            if num > thomeralex:
                ans = min(ans, num)
                break
                
        return ans
