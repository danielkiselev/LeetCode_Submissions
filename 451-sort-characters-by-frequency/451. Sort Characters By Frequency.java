class Solution {
    public String frequencySort(String s) {
        TreeMap<Integer, ArrayList<String>> res = new TreeMap<Integer, ArrayList<String>>();
        HashMap<String, Integer> counter = new HashMap<String, Integer>();
        for(int i = 0; i<s.length(); i++){
            String c = s.substring(i,i+1);
            if(counter.containsKey(c)){
                counter.put(c, counter.get(c)+1);
            }
            else{
                counter.put(c, 1);
            }
        }
        for(String key : counter.keySet()){
            int count = counter.get(key);
            ArrayList <String> l = new ArrayList <String>();
            if(res.containsKey(count)){
                l = res.get(count);
                l.add(key);
                res.put(count, l);
            }
            else{
                l.add(key);
                res.put(count, l);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Integer amt : res.keySet()){
            ArrayList <String> l = res.get(amt);
            for(String letter : l){
                for(int i = 0; i<amt; i++){
                    sb.append(letter);
                }
            }
        }
        return sb.reverse().toString();
    }
}