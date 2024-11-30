class Solution {
    public int strongPasswordChecker(String s) {
        int sz = s.length();
        int res = 0;
        boolean upper = false;
        boolean lower = false;
        boolean digit = false;
        char prev0 = '~';
        char prev1 = '~';
        for(int i = 0; i<sz; i++){
            char curr = s.charAt(i);
            if(prev0  == '~'){
                prev0 = curr;
            }
            else if(prev1 == '~'){
                prev1 = curr;
            }
            else{
                if(prev0 == curr && prev1 == curr){
                    res++;
                    prev0 = '~';
                    prev1 = '~';
                }
                else
                {
                    prev0 = prev1;
                    prev1 = curr;
                }
            }
            if(Character.isDigit(curr)){
                digit = true;
            }
            else if(Character.isUpperCase(curr)){
                 upper = true;
            }
            else{
                lower = true;
            }
        }
        if(sz<6){
            res+=6-sz;
        }
        int localRes = 0;
        if(!digit){
            localRes++;
        }
        if(!lower){
            localRes++;
        }
        if(!upper){
            localRes++;
        }
        if(localRes>res){
            res = localRes;
        }
        if(sz>20){
            if(sz-20>res){
                res = sz-20;
            }
        }

        return res;
    }
}