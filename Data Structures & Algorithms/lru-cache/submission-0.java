class LRUCache {

    // Primary storage for O(1) lookups
    private Map<Integer, Node> map = new HashMap<>();
    private int cap;
    
    // Permanent dummy boundary nodes
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.cap = capacity;
        
        // Initialize dummy head and tail
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        
        // Wire them to each other initially
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        
        // Move the accessed node to the front
        getToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node n = map.get(key);
        
        if (n == null) {
            // Check if cache is full before adding a new node
            if (map.size() == cap) {
                removeFromTail();
            }
            
            // Create and wire the new node
            n = new Node(key, value);
            map.put(key, n);
            addToHead(n);
            
        } else {
            // Key already exists: update its value and move to front
            n.value = value;
            getToHead(n);
        }
    }

    // Helper: Safely plucks a node from its current spot and places it at the front
    private void getToHead(Node n) {
        removeNode(n);
        addToHead(n);
    }

    // Helper: Links a node right after the dummy head
    private void addToHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    // Helper: Disconnects a node from its neighbors
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper: Evicts the least recently used node (sitting right before dummy tail)
    private void removeFromTail() {
        Node lru = tail.prev;
        removeNode(lru);          // Remove from Doubly Linked List
        map.remove(lru.key);      // Evict from Map using the key stored in the node
    }
}

class Node {
    int key;
    int value;
    Node next;
    Node prev;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}