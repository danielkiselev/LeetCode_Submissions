class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2){
            return 0;
        }
        int profit = 0;
        int prev = prices[0];
        for(int i = 1; i<prices.length;i++){
            int curr = prices[i];
            if(curr>prev){
                profit+=curr-prev;
                prev = curr;
            }
            else if(curr<prev){
                prev = curr;
            }
        }
        return profit;
    }
}