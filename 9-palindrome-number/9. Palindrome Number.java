class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        String s = Integer.toString(x);
        if(s == null){
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                sb.append(s.charAt(i));
            }
        }
        String standard = sb.toString();
        sb.reverse();
        String rev = sb.toString();
        if((standard.toUpperCase()).equals(rev.toUpperCase())){
            return true;
        }
        return false;
    }
}