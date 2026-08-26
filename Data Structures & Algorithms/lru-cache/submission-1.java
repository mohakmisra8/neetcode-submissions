class LRUCache {

    private Map<Integer, Node> map;
    int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addAtEnd(Node node) {
        Node prevNode = tail.prev;
        tail.prev.next = node;
        node.next = tail;
        tail.prev = node;
        node.prev = prevNode;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        addAtEnd(node);
        return node.val;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            remove(node);
            addAtEnd(node);
        } else {
            if(map.size() == capacity) {
                Node node = head.next;
                remove(node);
                map.remove(node.key);

            }

            Node newNode = new Node(key, value);
            addAtEnd(newNode);
            map.put(key, newNode);
        }
        
    }

    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
