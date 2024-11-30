class Solution {
    String A;
    String B;
    String C;
    public boolean isInterleave(String A, String B, String C) {
        this.A = A;
        this.B = B;
        this.C = C;
        if(A.length() == 0){
            if(B.equals(C)){
                return true;
            }
            return false;
        }
        if(B.length() == 0){
            if(A.equals(C)){
                return true;
            }
            return false;
        }
        if((A.length()+B.length())!=C.length()){
            return false;
        }
        return checker(A.length()-1,B.length()-1,C.length()-1);
    }
    
    boolean checker(int indexA, int indexB, int indexC){
        if(indexC< 0){
            return true;
        }
        if(indexA>=0){
            if(A.substring(indexA,indexA+1).equals(C.substring(indexC,indexC+1))){
                if(checker(indexA-1,indexB, indexC-1)){
                    return true;
                }
            }
        }
        if(indexB>=0){
            if(B.substring(indexB,indexB+1).equals(C.substring(indexC,indexC+1))){
                if(checker(indexA,indexB-1, indexC-1)){
                    return true;
                }
            }
        }
        return false;
    }
}