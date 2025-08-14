# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def modifiedList(self, nums: List[int], head: Optional[ListNode]) -> Optional[ListNode]:
        num_set = set(nums)
        
        d = ListNode(-1)
        d.next = head

        prev = d
        current = head

        while current:
            if current.val in num_set:
                prev.next = current.next
            else:
                prev = current
            current = current.next
        
        return d.next
