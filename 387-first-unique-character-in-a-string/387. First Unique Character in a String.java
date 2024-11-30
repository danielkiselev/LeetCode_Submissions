class Solution {
    public int firstUniqChar(String s) {
        char[] data = s.toCharArray();
        int [] charCounter = new int[26];
        for(int i = 0; i<data.length; i++){
            charCounter[data[i]-'a'] +=1;
        }
        for(int i = 0; i<data.length; i++){
            if(charCounter[data[i]-'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}