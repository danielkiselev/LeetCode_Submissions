class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bad = new HashSet<String>();
        for(int i = 0; i<banned.length; i++){
            bad.add(banned[i]);
        }
        HashMap<String, Integer> tracker = new HashMap<String, Integer>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<paragraph.length(); i++){
            char curr = paragraph.charAt(i);
            if(Character.isLetter(curr)){
                char lower = Character.toLowerCase(curr);
                sb.append(lower);
            }
            else if(sb.length() != 0){
                if(!(bad.contains(sb.toString()))){
                    int val = 1;
                    if(tracker.containsKey(sb.toString())){
                        val = tracker.get(sb.toString())+1;
                    }
                    tracker.put(sb.toString(), val);
                }
                sb = new StringBuilder();
            }
        }
        int res = 0;
        String resS = sb.toString();
        for(String key : tracker.keySet()){
            int temp = tracker.get(key);
            if(res<temp){
                res = temp;
                resS = key;
            }
        }
        return resS;
        
    }
}