class MovingAverage {

    /** Initialize your data structure here. */
    
    ArrayDeque<Integer> data;
    double size;
    double total = 0;
    public MovingAverage(int size) {
        data = new ArrayDeque<Integer>();
        this.size =(double) size;
    }
    
    public double next(int val) {
        if(data.size()==size){
            total-=data.poll();
            data.add(val);
            total+=(double)val;
            return (total/size);
        }
        total+=(double)val;
        data.add(val);
        return total/(double)data.size();
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */