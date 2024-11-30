class Solution {
    public int numJewelsInStones(String J, String S) {
        HashSet<String> Jewls = new HashSet<String>();
        for(int i = 0; i<J.length(); i++){
            Jewls.add(J.substring(i, i+1));
        }
        int res = 0;
        for(int i = 0; i<S.length(); i++){
            if(Jewls.contains(S.substring(i,i+1))){
                res++;
            }
        }
        return res;
    }
}