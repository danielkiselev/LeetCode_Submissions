class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length ==1 ){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robber(nums, 0, nums.length-2),robber(nums, 1, nums.length-1) );
        
        
    }
    
    private int robber(int[] nums, int start, int end){
        int [] res = new int [end-start+1];
        for(int i = start; i<=end; i++){
            res[i-start] = nums[i];
            if(i-2>=start){
                res[i-start]+= res[i-start-2];
            }
            if(i-1>=start){
                                res[i-start] = Math.max(res[i-start], res[i-start-1]);

            }
            
        }
        return Math.max(res[res.length-1], res[res.length-2]);
    }
}