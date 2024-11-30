class Solution {
    public int leastInterval(char[] tasks, int n) {
        ArrayDeque <String> cache  = new ArrayDeque <String>();
        HashMap<String, Integer> data = new HashMap<String, Integer>();
        for(char c : tasks){
            String curr = Character.toString(c);
            int count = 1;
            if(data.containsKey(curr)){
                count += data.get(curr);
            }
            data.put(curr, count);
        }
        int res = 0;
        while(data.size()>0){
            ValueComparator bvc = new ValueComparator(data);
            TreeMap<String, Integer> sorted = new TreeMap<String, Integer>(bvc);
            sorted.putAll(data);
            HashMap<String, Integer> resData = new HashMap<String, Integer>();
            resData = (HashMap)data.clone();
            System.out.println("data: "+ data);
            boolean proc = false;
            for(String key : sorted.keySet()){
                int sz = data.get(key);
                if(sz>0){
                    if(cache.size()>n){
                        cache.removeFirst();
                        proc = true;
                        break;
                    }
                    if(cache.contains(key)){
                        continue;
                    }
                    else{
                        proc = true;
                        res+=1;
                        cache.add(key);
                        sz-=1;
                        if(sz > 0){
                            data.put(key, sz);
                            resData.put(key, sz);
                        }
                        else if(sz == 0){
                            resData.remove(key);
                        }
                    }
                }
                else{
                    resData.remove(key);
                }
            }
            System.out.println(cache);
            if (!proc){
                cache.add("idle");
                res+=1;
            }
            if (resData.size() == 0){
                return res;
            }
            data = (HashMap)resData.clone();
            
            
        }
        return res;
    }
}



class ValueComparator implements Comparator<String> {
    Map<String, Integer> base;

    public ValueComparator(Map<String, Integer> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with
    // equals.
    public int compare(String a, String b) {
        if ((base.containsKey(a)) && (base.containsKey(b))){
            if (base.get(a) >= base.get(b)) {
                return -1;
            } else {
                return 1;
            } // returning 0 would merge keys
        }
        return 0;
    }
}

/*
            String curr = Character.toString(c);
            if(!data.contains(curr)){
                
            }

*/