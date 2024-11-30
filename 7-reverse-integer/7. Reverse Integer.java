class Solution {
    public int reverse(int x) {
        if(x == Integer.MAX_VALUE || x == Integer.MIN_VALUE){
            return 0;
        }
        boolean neg = false;
        if(x<0){
            neg = true;
            x = x*-1;
        }
        char[] xC = String.valueOf(x).toCharArray();
        char[] xCrev = new char [xC.length];
        char[] maxVal = String.valueOf(Integer.MAX_VALUE).toCharArray();
        for(int i = 0; i<xC.length; i++){
            xCrev[xC.length-(i+1)] = xC[i];
        }
        if(xCrev.length==maxVal.length){
            for(int i = 0; i<xCrev.length; i++){
                if(xCrev[i] == maxVal[i]){
                    continue;
                }
                else if(xCrev[i] > maxVal[i]){
                    return 0;
                }
                else{
                    break;
                }
            }
        }
        int res = Integer.parseInt(String.valueOf(xCrev));
        if (neg){
            return -1*res;
        }
        return res;
        
    }
}