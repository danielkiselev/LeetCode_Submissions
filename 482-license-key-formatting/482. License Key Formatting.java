class Solution {
    public String licenseKeyFormatting(String S, int K) {

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<S.length(); i++){
            if(S.charAt(i) != '-'){
                sb.append(S.charAt(i));
            }
        }
        if(sb.length() == 0){
            return "";
        }
        S = sb.toString().toUpperCase();
        sb = new StringBuilder();
        int firstSize = S.length()%K;
        Boolean first = true;
        int counter = 0;
        for(int i = 0; i<S.length(); i++){
            if(first && firstSize != 0){
                sb.append(S.charAt(i));
                counter++;
                if(counter == firstSize){
                    first = false;
                    if((i+1)<S.length()){
                        sb.append('-');
                        counter = 0;
                    }

                }
            }
            else{
                sb.append(S.charAt(i));
                counter++;
                if(counter == K && (i+1)<S.length()){
                    sb.append('-');
                    counter = 0;
                }
            }
        }
        return sb.toString();
    }
}