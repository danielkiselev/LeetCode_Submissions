class Solution {
    int[] prices;
    int fee;
    int [] profits;
    boolean [] done;
    public int maxProfit(int[] prices, int fee) {
        this.prices = prices;
        this.fee = fee;
        profits = new int[prices.length];
        done = new boolean[prices.length];
        return solver(0,0);
    }
    
    private int solver(int profit,int day){
        if(done[day]){
            return profits[day];
        }
        int buy = prices[day]; 
        int max = profit;
        for(int i = day+1; i<prices.length; i++ ){
            int res;
            if(buy>prices[i]){
                res = solver(profit, i);
                if(res>max){
                    max = res;
                }
            }
            else if(buy+fee<prices[i]){
                int made = prices[i]-(buy+fee);
                if(i+1<prices.length){
                    res = solver(profit, i+1)+made;
                }
                else{
                    res = profit+made;
                }
                if(res>max){
                    max = res;
                }
            }
        }
        done[day] = true;
        profits[day] = max;
        return max;
    }
}