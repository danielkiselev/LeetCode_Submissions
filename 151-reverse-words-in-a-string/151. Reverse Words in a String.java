public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length()<1){
            return s;
        }
        ArrayList <String> words = getWords(s);
        int count = words.size();
        Collections.reverse(words);
        StringBuilder sb = new StringBuilder();
        for(String word: words){
            sb.append(word);
            if(count>1){
                sb.append(" ");
                count--;
            }
        }
        return sb.toString();
    }
    
    private ArrayList<String> getWords(String s){
        ArrayList <String> res = new ArrayList <String>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            String curr = s.substring(i, i+1);
            if(!curr.equals(" ")){
                sb.append(curr);
            }
            else{
                if(sb.length() == 0){
                    
                }
                else{
                    res.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
        }
        if(sb.length() != 0){
            res.add(sb.toString());
        }
        return res;
    }
}