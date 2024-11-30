class Solution {
public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s==null || s.length()==0 || k<=0) return 0;
        int len=s.length();
        int i=0, j=0;
        int maxLen=0;
        LinkedHashMap<Character,Integer> map=new LinkedHashMap<Character,Integer>();
        for(char x:s.toCharArray()){
            if(map.containsKey(x)){
                map.remove(x);
                map.put(x,j);
            }else{
                if(map.size()==k){
                    maxLen=Math.max(maxLen,j-i);
                    char toRemove=map.keySet().iterator().next();
                    i=map.get(toRemove)+1;
                    map.remove(toRemove);
                }
                map.put(x,j);
            }
            j++;
        }
        maxLen=Math.max(maxLen,j-i);
        return maxLen;
    }
}