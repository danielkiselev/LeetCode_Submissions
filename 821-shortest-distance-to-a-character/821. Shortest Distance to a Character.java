class Solution {
    public int[] shortestToChar(String S, char C) {
        int [] res = new int [S.length()];
        for(int i = 0; i<S.length(); i++){
            res[i] = Integer.MAX_VALUE;
            if(S.charAt(i) == C){
                res[i] = 0;
            }
        }
        Integer counter = null;
        for(int i = 0; i<S.length(); i++){
            if(res[i] == 0){
                counter = 0;
            }
            else{
                if(counter != null){
                    counter++;
                    if(counter<res[i]){
                        res[i] = counter;
                    }
                }
            }
        }
        counter = null;
        for(int i = S.length()-1; i>=0; i--){
            if(res[i] == 0){
                counter = 0;
            }
            else{
                if(counter != null){
                    counter++;
                    if(counter<res[i]){
                        res[i] = counter;
                    }
                }
            }
        }
        return res;
    }
}