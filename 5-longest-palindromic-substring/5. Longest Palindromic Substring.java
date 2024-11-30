class Solution {
    public String longestPalindrome(String s) {
        if( s == null ||s.length() <=1 ){
            return s;
        }
        int i = 0;
        int j = 0;
        int max = 0;
        for(int k = 0; k < s.length(); k++) {
            if(isPalindrome(s, k - max - 1, k)) {
                i = k - max - 1;
                j = k;
                max += 2;
            }
            else if(isPalindrome(s, k - max, k)) {
                i = k - max; 
                j = k;
                max += 1;
            }
        }
        return s.substring(i, j + 1);
    }

    public boolean isPalindrome(String s, int i, int j) {
        if(i<0){
            return false;
        }
        while(i<j){
            if (!s.substring(i,i+1).equals(s.substring(j, j+1))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}