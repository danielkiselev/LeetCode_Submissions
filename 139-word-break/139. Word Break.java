class Solution {
    HashSet<String> dict;
    int maxLength = 0;
    int[] visited;
    public boolean wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<String>();
        for(String word : wordDict){
            if(word.length()>maxLength){
                maxLength = word.length();
            }
            dict.add(word);
        }
        visited = new int[s.length()];
        return trav(s, 0);
    }
    
    private boolean trav(String s, int index){
        if(index == s.length()){
            return true;
        }
        for(int i = index; i<s.length(); i++){
            if((i-index) == maxLength){
                break;
            }
            String curr = s.substring(index, i+1);
            if(visited[index] == 0 && dict.contains(curr)){
                if(trav(s, i+1)){
                    return true;
                }
            }
        }
        visited[index] = 1;
        return false;
    }
}