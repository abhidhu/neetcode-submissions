public class LRUCache {
    private final int capacity;
    private Node head;
    private Node tail;
    private int count=0;
    Map<Integer, Node> map = new HashMap<>();
    public LRUCache(int capacity){
        this.capacity=capacity;
    }

    public int get (int key){
        if(map.containsKey(key)){
            Node node =  map.get(key);
            removeFromMiddle(node);
            linkFront(node);
            return node.value;
        }
        return -1;
    }
    public void put(int key, int value){
        Node node=null;
        if(map.containsKey(key)){
            node = map.get(key);
            node.value=value;
            //we need to remove it from midle or from end
            removeFromMiddle(node);
        }
        else{
            if(capacity == count){
                //need to remove from last
                removeLast();
            }else{
                count++;
            }
            node = new Node(null, null, value, key);
        }
        //insert front of the linked list
        linkFront(node);
        map.put(key, node);
    }

    private void linkFront(Node node){
        node.pre=null;
        if(head==null){
            head=node;
            tail=node;
            head.next=null;
            return;
        }
        head.pre=node;
        node.next=head;
        head=node;
    }

    private void removeFromMiddle(Node node){
  
        Node pre=node.pre;
        Node next = node.next;
        if(node==head) head=next;
        if(node==tail) tail=pre;
        if(pre!=null){
            pre.next=next;
        }
        if(next!=null){
            next.pre=pre;
        }
    }

    private void removeLast(){
        if(tail != null){
            map.remove(tail.key);

            if(head==tail){
                head=null;
                tail=null;
            }else{
                tail=tail.pre;
                if(tail !=null){
                    tail.next=null;
                }
            }
        }
        
    }

    
}

class Node{
    Node pre;
    Node next;
    int value;
    int key;
    public Node(Node pre, Node next, int value, int key){
        this.pre=pre;
        this.next=next;
        this.value=value;
        this.key=key;
    }
}