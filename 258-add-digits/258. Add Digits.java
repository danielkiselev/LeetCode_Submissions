class Solution {
    public int addDigits(int num) {
        String curr = Integer.toString(num);
        while(curr.length()>1){
            int counter = 0;
            for(int i = 0; i<curr.length(); i++){
                counter+=Integer.parseInt(curr.substring(i, i+1));
            }
            num = counter;
            curr = Integer.toString(num);
            if(curr.length()<=1){
                return num;
            }
        }
        return num;
    }
}