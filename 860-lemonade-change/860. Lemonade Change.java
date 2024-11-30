class Solution {
    public boolean lemonadeChange(int[] bills) {
        if(bills.length == 0){
            return true;
        }
        int five = 0;
        int ten = 0;
        for(int i = 0; i<bills.length; i++){
            if(bills[i] == 5){
                five++;
            }
            else if(bills[i] == 10){
                five--;
                ten++;
                if(five < 0){
                    return false;
                }
            }
            else{
                five--;
                if(ten>0){
                    ten--;
                }
                else{
                    five-=2;
                }
                if(five < 0 || ten<0){
                    return false;
                }
            }

        }
        return true;
        
    }
}