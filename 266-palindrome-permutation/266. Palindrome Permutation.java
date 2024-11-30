class Solution {
    public boolean canPermutePalindrome(String s) {
        HashSet<String> data = new HashSet<String>();
        for(int i = 0; i<s.length(); i++){
            if(data.contains(s.substring(i,i+1))){
                data.remove(s.substring(i,i+1));
            }
            else{
                data.add(s.substring(i,i+1));
            }
        }
        if(data.size()<2){
            return true;
        }
        return false;
    }
}