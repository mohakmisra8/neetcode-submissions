class MovingAverage {

    private int[] arr;
    private int windowSum = 0;
    private int head = 0;
    private int count = 0;
    private int size;

    public MovingAverage(int size) {
        this.size = size;
        this.arr = new int[size];
        
    }
    
    public double next(int val) {
        ++count;

        int tail = (head + 1) % size;
        windowSum = windowSum - arr[tail] + val;

        head = (head+1) %size;
        arr[head] = val;

        return (windowSum*1.0) / Math.min(size, count);
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
