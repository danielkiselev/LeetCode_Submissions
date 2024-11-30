class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int [] data = new int[26];
        for(int i = 0; i<s.length(); i++){
            int index = s.charAt(i)-'a';
            data[index]++;
            int index1 = t.charAt(i)-'a';
            data[index1]--;
        }
        for(int i = 0; i<data.length; i++){
            if(data[i] != 0){
                return false;
            }
        }
        return true;
    }
}