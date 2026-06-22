class MinStack {
    private List<Integer> list;

    public MinStack() {
        this.list = new ArrayList<>();
        
    }
    
    public void push(int val) {
        list.add(val);
        
    }
    
    public void pop() {
        list.remove(list.size() -1);
        
    }
    
    public int top() {
        return list.get(list.size() -1);
        
    }
    
    public int getMin() {
        return Collections.min(list);
        
    }
}
