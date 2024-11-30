class Solution {
    public int compress(char[] chars) {
        if(chars.length<=1){
            return chars.length;
        }
        int index = 0;
        int count = 1;
        char curr = chars[0];
        for(int i = 1; i<chars.length; i++){
            if(curr == chars[i]){
                count++;
            }
            else if(curr != chars[i]){
                chars[index] = curr;
                index++;
                if(count>1){
                    String temp = Integer.toString(count);
                    for(int z = 0; z<temp.length(); z++){
                        char c = temp.charAt(z);
                        chars[index] = c;
                        index++;
                    }
                }
                curr = chars[i];
                count = 1;
            }
            if(i == (chars.length-1)){
                chars[index] = curr;
                index++;
                if(count>1){
                    String temp = Integer.toString(count);
                    for(int z = 0; z<temp.length(); z++){
                        char c = temp.charAt(z);
                        chars[index] = c;
                        index++;
                    }
                }
            }
        }
        return index;
        
    }
}