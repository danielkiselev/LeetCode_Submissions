
import java.math.BigInteger;class Solution {
    public int alternateDigitSum(int n) {
        Long res = Long.valueOf(0);
        char[] nCarray = Integer.toString(n).toCharArray();
        for(int i = 0; i<nCarray.length;i++){
            if(i%2 == 0){
                res+=(nCarray[i]-'0');

            }
            else{
                res-=(nCarray[i]-'0');
            }
        }

        return res.intValue();
    }
}