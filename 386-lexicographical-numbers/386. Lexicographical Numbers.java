class Solution {
    ArrayList<Integer> res = new ArrayList<Integer>();
    int n;
    public List<Integer> lexicalOrder(int n) {
        this.n = n;
        String in = Integer.toString(n);
        //int offSet = 1;
        //data[data.length-offSet] = 1;
        for(int digit = 1; digit<=9; digit++){
            for(int i = 0; i<in.length(); i++){
                int [] data = new int [in.length()];
                build(data, i, digit);
            }
        }
        return res;
    }
    
    private void build(int [] curr , int sz, int digit){
        curr[sz] = digit;
        int val = getVal(curr);
        if(val == -1){
            return;
        }
        res.add(val);
        if(sz > 0){
            for(int i = 1; i<=9; i++){
                build(curr, sz-1, i);
            }
        }
    }
    
    private int getVal(int [] data){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<data.length; i++){
            sb.append(data[i]);
        }
        sb.reverse();
        if(Integer.parseInt(sb.toString())>n){
            return -1;
        }
        return Integer.parseInt(sb.toString());
    }
}