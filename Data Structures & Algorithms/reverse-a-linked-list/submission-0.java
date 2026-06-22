/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        // reverse the rest then fix the pointer for the current node
        // if list is empty return null
        // use head.next to reverse the list
        // head.next.next = head so next node points back to current node
        // set head.next = null
        // return nrw head
        if(head == null) {
            return null;
        }
        ListNode newHead = head;
        if (head.next != null) {
            newHead = reverseList(head.next);
            head.next.next = head;
        }
        head.next = null;

        return newHead;

        
    }
}
