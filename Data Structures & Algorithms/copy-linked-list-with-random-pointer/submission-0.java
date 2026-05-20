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
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        Node dummyHead = new Node(-1);
        Node prev = dummyHead;
        while(curr != null){ 
            prev.next = new Node(curr.val);
            map.put(curr, prev.next);
            prev = prev.next;
            curr = curr.next;
        }
        curr = head;
        prev = dummyHead;
        while(curr != null){
            if(curr.random != null){
                prev.next.random = map.get(curr.random);
            }
            prev = prev.next;
            curr = curr.next;

        }
        return dummyHead.next;
    }
}
