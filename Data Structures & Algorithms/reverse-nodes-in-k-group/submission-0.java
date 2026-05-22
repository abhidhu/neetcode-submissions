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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
          return head;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode temp = dummyNode;
        ListNode run = temp;
        int count = 0;
        while(run != null && run.next != null){
          while(count < k && run != null){
            run = run.next;
            count++;
          }
          if(run == null){
            break;
          }
          count=1;
          ListNode last = run;
          run = run.next;
          ListNode s = temp.next;
          last.next = null;
          ListNode newHead = reverse(temp.next);
          temp.next = newHead;
          temp = s;
          temp.next = run;
        } 
        return dummyNode.next;
    }
    private ListNode reverse(ListNode head){
      ListNode prev = null;
      ListNode curr = null;
      ListNode next = head;
      while(next != null){
        curr = next;
        next = next.next;
        curr.next = prev;
        prev = curr;
      }
      return prev;
    }    
}
