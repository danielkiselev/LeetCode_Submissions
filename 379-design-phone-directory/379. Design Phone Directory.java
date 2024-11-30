class PhoneDirectory {

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    HashMap <Integer, Integer> numbers = new HashMap <Integer, Integer> ();
    ArrayDeque <Integer> avaliable = new ArrayDeque <Integer>();
    public PhoneDirectory(int maxNumbers) {
        for(int i = 0;i<maxNumbers; i++){
            numbers.put(i, 1);
            avaliable.add(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(avaliable.isEmpty()){
            return -1;
        }
        else{
            int res = avaliable.poll();
            numbers.put(res, -1);
            return res;
        }
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        if(numbers.containsKey(number)){
            if(numbers.get(number) == 1){
                return true;
            }
        }
        return false;
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if(numbers.containsKey(number)){
            if(numbers.get(number) == -1){
                numbers.put(number, 1);
                avaliable.add(number);
            }
        }
        else{
            numbers.put(number, 1);
            avaliable.add(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */