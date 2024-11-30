class Solution {
    public int integerBreak(int n) {
        int curr = n;
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(n==4){
            return 4;
        }
        if(n==3){
            return 2;
        }
        else if(n==2){
            return 1;
        }
        while(true){
            if(curr>3){
                int temp = (int)curr/3;
                int remain = (int)curr%3;
                if(remain==2){
                    return (int)(Math.pow(3, temp) *2);
                }
                if(remain==0){
                    return (int)(Math.pow(3, temp));
                }
                if(remain==1){
                    return (int)(Math.pow(3,temp-1) *(4));
                }

            }
            else{
                res.add(curr);
                break;
            }
        }
        Integer val = null;
        for(Integer i : res){
            if(val == null){
                val = i;
            }
            else{
                val = val * i;
            }
        }
        return val;
    }
}