class Solution {
    public int lengthOfLastWord(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1; i>=0; i--){
            if(s.substring(i,i+1).equals(" ")){
                if(sb.length()>0){
                    return sb.length();
                }
                else{
                    
                }
            }
            else{
                sb.append(s.substring(i,i+1));
            }
            
        }
        return sb.length();
        
    }
}