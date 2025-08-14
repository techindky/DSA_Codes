class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        #Approach 1 using sliding window
        i = 0
        for j in range(len(nums)):
            if nums[j] == 0:
                k-=1
            
            if k < 0:
                if nums[i] == 0:
                    k+=1
                i+=1

        return j - i + 1
        '''#Approach 2 using prefix sum and binary search
        # Step 1: Construct the prefix sum array for the number of zeros
        n = len(nums)
        prefix_zeros = [0] * (n + 1)
        for i in range(1, n + 1):
            prefix_zeros[i] = prefix_zeros[i - 1] + (1 if nums[i - 1] == 0 else 0)
        print(prefix_zeros)
        # Step 2: Initialize the result variable
        max_length = 0
        
        # Step 3: Use binary search for each starting point
        for left in range(n):
            # The number of zeros allowed from this starting point
            max_zeros = prefix_zeros[left] + k
            
            # Binary search to find the farthest end point
            low, high = left, n
            while low < high:
                mid = (low + high + 1) // 2
                if prefix_zeros[mid] <= max_zeros:
                    low = mid
                else:
                    high = mid - 1
            
            # Update the maximum length
            max_length = max(max_length, low - left)
        
        return max_length'''
