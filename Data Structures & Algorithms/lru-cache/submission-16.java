class LRUCache {

    private int capacity;
    private int curr;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.curr = 0;
        this.head = null;
        this.tail = null;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(map.get(key)==null){
            return -1;
        }
        Node node = map.get(key);
        removeMiddle(node);
        insertFront(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node==null){
            node = new Node(key, value);
            curr++;
            map.put(key, node);
        } else {
            removeMiddle(node);
            node.value = value;
        }
        insertFront(node);
        if(curr > capacity){
            removeLast();
        }

    }

    private void removeLast(){
        if(tail == null) return;
        map.remove(tail.key);//remove entry from map for tail as it will go to the end 
        Node prev = tail.prev;
        if(prev !=  null) {
            prev.next = null;
        } else {
            head = null;
        }
        tail = prev;       
        curr--;//we removed last so lets reduce the count
    }

    private void removeMiddle(Node node){ 
        Node prev = node.prev;
        Node next = node.next;
        if(prev != null){ 
            prev.next = node.next;
        } else {
            head = next;
        }

        if(next != null){
            next.prev = node.prev;
        } else {
            tail = prev;
        }
        node.prev = null;
        node.next = null;
    }

    private void insertFront(Node node) {
       node.next = head;
       node.prev = null;

       if(head != null){
          head.prev = node;
       }

       head = node;
       
       if(tail == null){
          tail = head;
       }
    }
}

class Node {
    int key;
    int value;
    Node next;
    Node prev;
    
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */