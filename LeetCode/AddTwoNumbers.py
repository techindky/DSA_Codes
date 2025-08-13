# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        firstNumber = 0
        count = 0
        current1 = l1
        while current1:
            firstNumber+=current1.val*pow(10,count)
            current1 = current1.next
            count+=1
        secondNumber = 0
        count = 0
        current2 = l2
        while current2:
            secondNumber+=current2.val*pow(10,count)
            current2 = current2.next
            count+=1
        result = firstNumber+secondNumber
        resultList = ListNode(int(str(result)[-1]))
        current3 = resultList
        for value in str(result)[:-1][::-1]:
            current3.next = ListNode(int(value))
            current3 = current3.next
        return resultList
