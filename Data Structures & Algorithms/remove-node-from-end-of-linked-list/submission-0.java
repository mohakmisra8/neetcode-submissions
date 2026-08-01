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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        ListNode curr = head;
        while(curr != null) {
            list.add(curr);
            curr = curr.next;
        }

        int indexToRemove = list.size() - n;
        if(indexToRemove == 0) {
            return head.next;
        }

        list.get(indexToRemove - 1).next = list.get(indexToRemove).next;
        return head;


    }
}
