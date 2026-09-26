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
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode next = dummy;
        ListNode curr = dummy;
        for(int i=0; i<n&&next.next != null; i++){
            next = next.next;
        }

        while(next.next != null){
            next = next.next;
            curr = curr.next;
        }
        next = curr.next;
        if(next != null){
            next=next.next;
        }
        curr.next = next;
        return dummy.next;
    }
}