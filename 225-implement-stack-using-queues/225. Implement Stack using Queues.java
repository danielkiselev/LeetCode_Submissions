class MyStack {

    /** Initialize your data structure here. */
    Queue<Integer> queue;
    public MyStack() {
        queue = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Queue<Integer> queueCopy = new LinkedList<Integer>();
        while(queue.size()>1){
            queueCopy.add(queue.poll());
        }
        int res = 0;
        if(!queue.isEmpty()){
            res = queue.poll();
        }
        
        queue = queueCopy;
        return res;
    }
    
    /** Get the top element. */
    public int top() {
        Queue<Integer> queueCopy = new LinkedList<Integer>(queue);
        int res = 0;
        while(queueCopy.size()>0){
            res =queueCopy.poll();
        }
        return res;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(queue.isEmpty()){
            return true;
        }
        return false;
        
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */