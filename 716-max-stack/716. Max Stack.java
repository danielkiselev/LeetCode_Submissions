class MaxStack {

    /** initialize your data structure here. */
    ArrayList<Integer> data = new ArrayList<Integer>();
    TreeMap<Integer, ArrayList<Integer>> tmap  = new TreeMap<Integer, ArrayList<Integer>>(Collections.reverseOrder()); 
              
    public MaxStack() {
        
    }

    public void push(int x) {
        data.add(x);
        ArrayList<Integer> temp = new ArrayList<Integer>();
        if(tmap.containsKey(x)){
            temp = tmap.get(x);
        }
        temp.add(data.size()-1);
        tmap.put(x,temp);
        
    }
    
    public int pop() {
        int index = data.size()-1;
        int res = data.remove(index);
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp = tmap.remove(res);
        if(temp.size()>1){
            temp.remove(Integer.valueOf(index));
            tmap.put(res, temp);
        }
        return res;
    }
    
    public int top() {
        return data.get(data.size()-1);
    }
    
    public int peekMax() {
        for(int key : tmap.keySet()){
            return key;
        }
        return -1;
    }
    
    public int popMax() {
        int res = 0;
        int index = 0;
        for(int key : tmap.keySet()){
            res = key;
            break;
        }
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp = tmap.remove(res);
        index = temp.get(temp.size()-1);
        data.remove(index);
        if(temp.size() > 1){
            temp.remove(temp.size()-1);
            tmap.put(res, temp);
        }
        return res;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */