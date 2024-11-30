class Solution {
    public double myPow(double x, int n) {
        if(n == 0 || x == 1){
            return 1;
        }
        boolean pos = false;
        if(n%2 == 0 || x>0){
            pos = true;
        }
        if(x == -1){
            if(pos){
                return 1;
            }
            return -1;
        }
        double res = x;
        if(n<0){
            for(int i = 0; i<Math.abs(n)-1; i++){
                try{
                    res*=x;
                    if((double)(1/Math.abs(res))<=(double)(1/Integer.MAX_VALUE)){
                        return 0;
                    }
                }
                catch(Exception e){
                    if(pos){
                        return (double)(1/Integer.MAX_VALUE);
                    }
                    else{
                        return (double)(1/Integer.MIN_VALUE);
                    }
                }
            }
            return (1/res);
        }
        else{
            for(int i = 0; i<Math.abs(n)-1;i++){
                try{
                    res*=x;
                    if(Math.abs(res)<=(double)(1/Integer.MAX_VALUE)){
                        return 0;
                    }
                }
                catch(Exception e){
                    if(pos){
                        return (double)(Integer.MAX_VALUE);
                    }
                    else{
                        return (double)(Integer.MIN_VALUE);
                    }
                }
            }
            return res;
        }
    }
}