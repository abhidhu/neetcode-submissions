class MinStack {

    private ArrayList<Integer>  stack = new ArrayList<>();
    private ArrayList<Integer>  minStack = new ArrayList<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.add(val);
        if(minStack.size() == 0){
            minStack.add(val);
            return;
        }
        minStack.add(Math.min(val, minStack.get(minStack.size() - 1)));
    }
    
    public void pop() {
        stack.remove(stack.size() -1 );
        minStack.remove(minStack.size()-1);
    }
    
    public int top() {
        return stack.get(stack.size()-1);
    }
    
    public int getMin() {
        return minStack.get(minStack.size()-1);
    }
}
