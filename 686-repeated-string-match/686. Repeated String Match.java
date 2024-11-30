class Solution {
    String A;
    String B;
    public int repeatedStringMatch(String A, String B) {
        this.A = A;
        this.B = B;
        int indexB = B.length()-1;
        for(int i = A.length()-1; i>=0; i--){
            String currA = A.substring(i, i+1);
            if(currA.equals(B.substring(indexB,indexB+1))){
                int res = creator(i-1, indexB-1, 1);
                if(res != -1){
                    return res;
                }
            }
        }
        return -1;
    }
    
    private int creator(int indexA, int indexB, int counter){
        if(indexB == -1){
            return counter;
        }
        if(indexA == -1){
            indexA = A.length()-1;
            counter++;
        }
        String currA = A.substring(indexA, indexA+1);
        String currB = B.substring(indexB, indexB+1);
        if(currA.equals(currB)){
            return creator(indexA-1, indexB-1, counter);
        }
        else{
            return -1;
        }
    }
    
    
}