# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def splitListToParts(self, head: Optional[ListNode], k: int) -> List[Optional[ListNode]]:
        length = 0
        current = head
        while current:
            length += 1
            current = current.next
        part_length = length // k
        extra = length % k

        parts = []
        current = head
        for i in range(k):
            part = current
            length = part_length + (1 if i < extra else 0)
            
            for j in range(length - 1):
                if current:
                    current = current.next

            if current:
                next_part = current.next
                current.next = None
                current = next_part

            parts.append(part)
        return parts
