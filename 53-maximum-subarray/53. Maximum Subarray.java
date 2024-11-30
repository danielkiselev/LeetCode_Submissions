class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        // int [] n = new int[nums.length];
        // n[0] = nums[0];
        for(int i = 1; i<nums.length; i++){
            nums[i] = Math.max(nums[i-1]+nums[i], nums[i]);
            if(nums[i]>res){
                res = nums[i];
            }
        }
        return res;
        
    }
}