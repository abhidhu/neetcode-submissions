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
    public void reorderList(ListNode head) {

        if(head == null || head.next == null || head.next.next == null){
            return;
        }

        //devide list into 2part
        ListNode s = head;
        ListNode f = head;
        ListNode prevSlow = null;
        while(f != null && f.next != null){
            prevSlow = s;
            s = s.next;
            f = f.next.next;
        }
        if(prevSlow != null){
            prevSlow.next = null;
        }

        //reverse 2nd half of the linked list
        s = reverse(s);

        if(s == null){
            return ;
        }
 // Step 3: Cleanly weave them together
        ListNode first = head;
        ListNode second = s;
        
        while (first != null && second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            
            // Connect first half to second half node
            first.next = second; 
            
            // CRITICAL FIX 2: Connect second half node back to the next first half node
            if (temp1 != null) {
                second.next = temp1; 
            }
            
            // Move pointers forward for the next iteration
            first = temp1;
            second = temp2;
        }
    }

    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode curr = head;
        ListNode next = curr;
        ListNode prev = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}