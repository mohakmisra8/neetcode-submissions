class LRUCache {

    class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode prev;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private Map<Integer, ListNode> map;
    private ListNode head;
    private ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new ListNode(0,0);
        this.tail = new ListNode(0,0);
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        ListNode node = map.get(key);
        remove(node);
        insertAtFront(node);
        return node.val;
    }

    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            ListNode node = map.get(key);
            node.val = value;
            remove(node);
            insertAtFront(node);
        } else{
            if(map.size() == capacity) {
                ListNode lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
            ListNode newNode = new ListNode(key, value);
            insertAtFront(newNode);
            map.put(key, newNode);

        }
        
    }

    private void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtFront(ListNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
