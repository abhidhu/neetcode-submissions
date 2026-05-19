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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode head = null;
        ListNode currNode = null;
        while(list1 != null && list2 != null){
            ListNode minVal = null;
            if(list1.val <= list2.val){
                minVal = list1;
                list1=list1.next;
                minVal.next=null;
            }else{
                minVal = list2;
                list2=list2.next;
                minVal.next=null  ;             
            }
            if(head == null){
                head = minVal;
                currNode = minVal;
            }else{
                currNode.next = minVal;
                currNode = minVal;
            }
        }
        if(list1 != null){
            currNode.next = list1;
        }

        if(list2 != null){
            currNode.next = list2;
        }
        return head;
    }
}