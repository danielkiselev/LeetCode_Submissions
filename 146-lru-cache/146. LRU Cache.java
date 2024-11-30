class LRUCache {
    
    ArrayDeque<Integer> activeKey;
    HashMap<Integer, Integer> data;
    int max = 0;
    public LRUCache(int capacity) {
        max = capacity;
        activeKey = new ArrayDeque<Integer>();
        data = new HashMap<Integer, Integer>();
    }
    
    public int get(int key) {
        if(data.containsKey(key))
        {
            activeKey.remove(key);
            activeKey.add(key);
            return data.get(key);
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        if(data.containsKey(key)){
            data.put(key, value);
            activeKey.remove(key);
            activeKey.add(key);
        }
        else if(activeKey.size() == max){
            int x = activeKey.poll();
            data.remove(x);
            data.put(key, value);
            activeKey.add(key);
        }
        else{
            data.put(key, value);
            activeKey.add(key);
        }
        
        
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */