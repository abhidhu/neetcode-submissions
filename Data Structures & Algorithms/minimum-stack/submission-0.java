class MinStack {

    private ArrayList<Integer>  stack = new ArrayList<>();
    int i = 0;

    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.add(i++, val);
    }
    
    public void pop() {
        stack.remove(--i);
    }
    
    public int top() {
        return stack.get(i-1);
    }
    
    public int getMin() {
        int min = Integer.MAX_VALUE;;
        for(Integer i : stack){
            min = Math.min(min, i);
        }
        return min;
    }
}
