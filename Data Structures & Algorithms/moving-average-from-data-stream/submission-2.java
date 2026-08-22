class MovingAverage {
    Deque queue = new ArrayDeque<Integer>();
    int size = 0;
    int windowSum = 0;
    int count = 0;


    public MovingAverage(int size) {
        this.size = size;
        
    }
    
    public double next(int val) {
        ++ count;
        queue.add(val);
        int tail = count > size ? (int) queue.poll() : 0;

        windowSum = windowSum - tail + val;

        return (windowSum*1.0)/ Math.min(size, count);
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
