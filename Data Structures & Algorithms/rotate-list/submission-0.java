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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }

        ListNode curr = head;
        int n=1;
        while(curr.next != null) {
            n++;
            curr = curr.next;
        }
        curr.next = head;
        k %= n;
        for(int i =0; i< n-k;i++) {
            curr = curr.next;
        }
        head=curr.next;
        curr.next = null;
        return head;

    }
}