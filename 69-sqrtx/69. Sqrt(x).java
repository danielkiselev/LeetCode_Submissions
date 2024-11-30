class Solution {
    public int mySqrt(int x) {
        int curr=-1;
        int prev=-1;
        if(x == 1 || x==0){
            return x;
        }
        for(long i = 0;i<= ((x/2) +1);i++ ){
            long test = i*i;
            if(test == x){
                return (int)i;
            }
            else if(test>=x && prev !=-1){
                return prev;
            }
            else if(test<x){
                prev = (int)i;
            }

        }
        return prev;
    }
}