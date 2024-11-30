class MyQueue {

    /** Initialize your data structure here. */
    ArrayDeque<Integer> stack;
    public MyQueue() {
        stack = new ArrayDeque<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        ArrayDeque<Integer> replacement = new  ArrayDeque<Integer>();
        int count = stack.size();
        for(int i = 0; i<count-1; i++){
            replacement.push(stack.pop());
        }
        int res = stack.pop();
        for(int i = 0; i<count-1; i++){
            stack.push(replacement.pop());
        }
        return res;
    }
    
    /** Get the front element. */
    public int peek() {
        ArrayDeque<Integer> replacement = new  ArrayDeque<Integer>(stack);
        int count = stack.size();
        for(int i = 0; i<count-1; i++){
            stack.pop();
        }
        count = stack.pop();
        stack = replacement;
        return count;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */