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
    if (head == null || head.next == null) {
        return head;  // Base case: empty or single node
    }
    
    ListNode newHead = reverseList(head.next);  // Recurse
    head.next.next = head;  // Reverse the pointer
    head.next = null;        // Break old link
    
    return newHead;  // Pass the new head up
        // ListNode prev= null;
        // ListNode curr = head;
        // ListNode next = curr;
        // while(next != null){
        //     next = curr.next;
        //     curr.next=prev;
        //     prev = curr;
        //     if(next != null){
        //         curr = next;
        //     }
        // }
        // return curr;
    }
}
