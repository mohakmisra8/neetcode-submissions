class MedianFinder {

    private PriorityQueue<Integer> minHeap; // upper half. smallest elemt in the large half
    private PriorityQueue<Integer> maxHeap; // smaller half. go here peek returns largest of smallest numbers

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
    }
    
    public void addNum(int num) {
        maxHeap.offer(num); // add to small half
        minHeap.offer(maxHeap.poll()); // move its top to large half (enforces ordering)

        // rebalance
        if(minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
        
    }
    
    public double findMedian() {
        // odd total -> maxHeap holds middle element
        if(maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() +minHeap.peek())/2.0;
        
    }
}
