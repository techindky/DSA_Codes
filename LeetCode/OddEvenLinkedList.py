# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head  # If the list is empty or has only one node, no rearrangement is needed.
        
        # Initialize odd and even lists
        odd_head = odd = head
        even_head = even = head.next
        
        # Traverse the list, separating odd and even nodes
        while even and even.next:
            odd.next = even.next  # Connect the next odd node
            odd = odd.next
            even.next = odd.next  # Connect the next even node
            even = even.next
        
        # Connect the end of the odd list to the head of the even list
        odd.next = even_head
        
        return odd_head
