class MinStack {

    /** initialize your data structure here. */
    TreeMap <Integer, Integer> min;
    ArrayDeque <Integer> stack;
    public MinStack() {
        stack = new ArrayDeque <Integer>();
        min = new TreeMap <Integer, Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(min.containsKey(x)){
            min.put(x, min.get(x)+1);
        }
        else{
            min.put(x,1);
        }
    }
    
    public void pop() {
        Integer x = stack.poll();
        if(x != null){
            if(min.get(x) > 1){
                min.put(x, min.get(x)-1);
            }
            else{
                min.remove(x);
            }
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        for(int key : min.keySet()){
            return key;
        }
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */