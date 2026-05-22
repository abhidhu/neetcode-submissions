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
// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {

        
//         // PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
//         // for(int i=0;i<lists.length; i++){
//         //     ListNode node = lists[i];
//         //     if(node != null){
//         //         pq.offer(node);
//         //     }
//         // }
//         // ListNode dummyNode = new ListNode(-1);
//         // ListNode curr = dummyNode;
//         // while(pq.peek() != null){
//         //     ListNode node = pq.poll();
//         //     curr.next = node;
//         //     if(node.next != null){
//         //         node = node.next;
//         //         pq.offer(node);
//         //     }
//         //     curr = curr.next;
//         //     curr.next = null;
//         // }
//         // return dummyNode.next;
//     }
// }












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
    if(lists == null || lists.length == 0){
      return null;
    }
    //devide and conquere approach practice
    return merge(lists, 0, lists.length - 1);
  }
    
  private ListNode merge(ListNode[] lists, int left, int right){
    if(right == left){
      return lists[left];
    }
    int mid = left + (right - left)/2;
    ListNode firstHalf = merge(lists, left, mid);
    ListNode secondHalf = merge(lists, mid+1, right);
    return mergeTwoList(firstHalf, secondHalf);
  }
	
	private ListNode mergeTwoList(ListNode l1, ListNode l2){
		if(l1 == null){
      return l2;
    } else if(l2==null){
      return l1;
    }
    ListNode dummyNode = new ListNode(-1);
    ListNode temp = dummyNode;
    while(l1 != null && l2 != null){
      if(l1.val < l2.val){
        temp.next = l1;
        l1 = l1.next;
      }else{
        temp.next = l2;
        l2 = l2.next;
      }
      temp = temp.next;
    }
    temp.next = l1 != null ? l1 : l2;
    return dummyNode.next;
	}
}