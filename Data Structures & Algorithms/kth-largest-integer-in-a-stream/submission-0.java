class KthLargest {
    private int k;
    private PriorityQueue<Integer> heap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new PriorityQueue<Integer>();
        for(int n: nums) {
            add(n);
        }
        
    }
    
    public int add(int val) {
        if(heap.size() < k || heap.peek() < val) {
            heap.add(val);
            if(heap.size() > k) {
                heap.remove();
            }
        }

        return heap.peek();
        
    }
}
