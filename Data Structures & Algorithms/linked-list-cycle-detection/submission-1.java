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
    public boolean hasCycle(ListNode head) {
        ListNode slowRunner = head;
        ListNode fastRunner = head;
        while(fastRunner != null && fastRunner.next != null){
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
            if(slowRunner == fastRunner){
                return true;
            }
        }
        return false;
    }
}
