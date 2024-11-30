class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Arrays.sort(words);
        HashMap <String, Integer> hm  = new HashMap <String, Integer>();
        HashMap <Integer, String> hm1  = new HashMap <Integer, String>();
        ArrayList<String> res = new ArrayList<String>();
        int index = 0;
        while(index<words.length){
            int counter = 0;
            String curr = words[index];
            index++;
            counter++;
            if(index<words.length){
                while((index+1<words.length) && (curr == words[index+1])){
                    counter++;
                    index++;
                }
            }
            if(res.size()==0){
                res.add(curr);
            }
            else if(res.size()<k){
                for(String i: res){
                    if(hm.get(i)<counter){
                        int t = res.indexOf(i);
                        res.remo(i);
                        res.add(t, curr);
                        break;
                    }
                }
            }
            else{
                for(String i: res){
                    if(hm.get(i)<counter){
                        int t = res.indexOf(i);
                        res.remove(i);
                        res.add(t, curr);
                        break;
                    }
                }
            }

            hm.put(curr, counter);
        }
    return res;
    }
}