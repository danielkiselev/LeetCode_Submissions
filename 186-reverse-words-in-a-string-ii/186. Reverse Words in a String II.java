class Solution {
    public void reverseWords(char[] str) {
        int sz = str.length;
        str = swap(0, sz, str);
        int curr = 0;
        for(int i = 0; i<sz; i++){
            if(str[i] == ' '){
                str = swap(curr, curr+i, str);
                curr = i+1;
            }
        }
        str = swap(curr, curr+sz, str);
    }
    
    public char[] swap(int startIndex, int endIndex, char[] str){
        for(int i = startIndex; i<(endIndex/2); i++){
            char t;
            t = str[i];
            str[i] = str[(endIndex-1)-i] ;
            str[(endIndex-1)-i] = t; 
        }
        return str;
    }
}