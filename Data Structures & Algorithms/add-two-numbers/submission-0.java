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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode node = dummyNode;
        int c = 0;
        while(l1 != null || l2 != null || c > 0){
            int i = l1 != null ? l1.val : 0;
            int j = l2 != null ? l2.val : 0;
            int reminder = (i+j+c)%10;
            node.next = new ListNode(reminder);
            node = node.next;
            c = (i+j+c)/10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        return dummyNode.next;

    }
}