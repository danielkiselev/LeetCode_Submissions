class Solution {
    public int myAtoi(String s) {
        int counter = 0;
        char [] sChar = s.toCharArray();
        boolean neg = false;
        boolean pos = false;
        boolean proc = false;
        int [] numberHolder = new int [sChar.length];
        for(int i = 0; i<s.length();i++){
            if(sChar[i] >= '0' && sChar[i] <= '9'){
                proc = true;
                if(sChar[i] == '0'&&counter == 0){
                    continue;
                }
                numberHolder[counter] = sChar[i]-'0';
                counter++;
            }
            else if(sChar[i] == '-'){

                if(proc){
                    break;
                }
                                if(pos){
                    return 0;
                }
                proc = true;
                                neg = true;


                continue;
            }
            else if(sChar[i] == '+'){

                                if(proc){
                    break;
                }
                                if(neg){
                    return 0;
                }
                proc = true;
                                pos = true;


                continue;
            }
            else if(sChar[i] == ' '&&!proc){
                continue;
            }
            else{
                break;
            }
        }
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        if(counter>10){
            if(neg){
                return min;
            }
            return max;
        }
        else if(counter == 0){
            return 0;
        }
        else if(counter == 10){
            String maxS = Integer.toString(max);
            char [] maxChar = maxS.toCharArray();
            for(int i = 0; i<counter;i++){
                if(maxChar[i]-'0'<numberHolder[i]){
                    if(neg){
                        return min;
                    }
                    return max;
                }
                else if(maxChar[i]-'0'==numberHolder[i]){
                    continue;
                }
                else{
                    break;
                }
            }
        }
        int res = 0;
        for(int i = 0; i<counter; i++){
            res+=numberHolder[i]*Math.pow(10,((counter-1)-i));
        }
        if(neg){
            return res*-1;
        }
        return res;
        
    }
}