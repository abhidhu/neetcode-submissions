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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(int i=0;i<lists.length; i++){
            ListNode node = lists[i];
            if(node != null){
                pq.offer(node);
            }
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;
        while(pq.peek() != null){
            ListNode node = pq.poll();
            curr.next = node;
            if(node.next != null){
                node = node.next;
                pq.offer(node);
            }
            curr = curr.next;
            curr.next = null;
        }
        return dummyNode.next;
    }
}