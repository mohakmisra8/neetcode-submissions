class MedianFinder {

    private List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
        
    }
    
    public void addNum(int num) {
        list.add(num);
        
    }
    
    public double findMedian() {
        Collections.sort(list);
        int size = list.size();

        if ((size &1) == 1) {
            return list.get(size/2);
        } else {
            return (list.get(size/2) + list.get(size/2 - 1)) /2.0;
        }
        
    }
}
