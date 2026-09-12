# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        self.cur = head

        def rec(node):
            if node is not None:
                if not rec(node.next):
                    return False
                
                if self.cur.val != node.val:
                    return False
                self.cur = self.cur.next
            return True
        
        return rec(head)
        