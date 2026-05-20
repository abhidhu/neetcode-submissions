/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node curr = head;
        while(curr != null){
            Node temp = new Node(curr.val);
            temp.next = curr.next;
            curr.next = temp;
            curr = temp.next;
        }
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        // Node dummyNode = new Node(-1);
        // Node node = dummyNode;
        // curr = head;
        // while(curr != null){
        //     node.next = curr.next;
        //     curr = curr.next.next;
        //     node = node.next;
        // }

        curr = head;
        Node dummy = new Node(-1);
        Node cloneCurr = dummy;
        
        while (curr != null) {
            Node clone = curr.next;
            
            cloneCurr.next = clone;
            cloneCurr = cloneCurr.next;
            
            curr.next = clone.next;
            curr = curr.next;
        }


        return dummy.next;








        // Map<Node, Node> map = new HashMap<>();
        // Node curr = head;
        // Node dummyHead = new Node(-1);
        // Node prev = dummyHead;
        // while(curr != null){ 
        //     prev.next = new Node(curr.val);
        //     map.put(curr, prev.next);
        //     prev = prev.next;
        //     curr = curr.next;
        // }
        // curr = head;
        // prev = dummyHead;
        // while(curr != null){
        //     if(curr.random != null){
        //         prev.next.random = map.get(curr.random);
        //     }
        //     prev = prev.next;
        //     curr = curr.next;

        // }
        // return dummyHead.next;
    }
}
