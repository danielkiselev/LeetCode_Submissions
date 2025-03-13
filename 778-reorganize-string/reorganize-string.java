class Solution {
    public String reorganizeString(String s) {
        int [] letterHolder = new int[26];
        for(char c: s.toCharArray()){
            int currI = c-'0'-49;
            letterHolder[currI]++;
        }
        StringBuilder sb = new StringBuilder();
        int prev = -1;
        while(sb.length()<s.length()){
            int maxI = -1;
            for(int i=0; i<26; i++){
                if(prev != i && letterHolder[i]>0){
                    if(maxI == -1){
                        maxI = i;
                    }
                    
                    else if(letterHolder[i] > letterHolder[maxI]){
                        maxI = i;
                    }
                }    
            }
            if(maxI == -1){
                return "";
            }
            sb.append(Character.toString(maxI+'0'+49));
            letterHolder[maxI]--;
            prev = maxI;



        }
        return sb.toString();
        
    }
}