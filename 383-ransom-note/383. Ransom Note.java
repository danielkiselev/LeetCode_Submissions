class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length()>magazine.length()){
            return false;
        }
        HashMap <String, Integer> hm = new HashMap <String, Integer>();
        for(int i = 0; i<magazine.length(); i++){
            String curr = magazine.substring(i, i+1);
            if(hm.containsKey(curr)){
                hm.put(curr, hm.get(curr)+1);
            }
            else{
                hm.put(curr, 1);
            }
        }
        
        for(int i = 0; i<ransomNote.length(); i++){
            String curr = ransomNote.substring(i, i+1);
            if(hm.containsKey(curr)){
                int val = hm.get(curr)-1;
                if(val<0){
                    return false;
                }
                hm.put(curr, val);
            }
            else{
                return false;
            }
        }
        return true;
    }
}