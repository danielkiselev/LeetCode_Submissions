class Solution {
    public int findNthDigit(int n) {
        int curr = 0;
        String currS = Integer.toString(curr);
        int index = 0;
        while(true){
            if(n==0){
                return Integer.parseInt(currS.substring(index, index+1));
            }
            else{
                n--;
                if(currS.length()>index+1){
                    index++;
                }
                else{
                    curr++;
                    currS = Integer.toString(curr);
                    index = 0;
                }
            }
        }
    }
}