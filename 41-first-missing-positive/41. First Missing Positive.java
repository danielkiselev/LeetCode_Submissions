class Solution {
    public int firstMissingPositive(int[] nums) {
        int [] res = new int[nums.length];
        for(int i =0; i<nums.length; i++){
            if(nums[i]>0 && nums[i]<=nums.length){
                res[nums[i]-1] = 1;
            }
        }
        for(int i =0; i<nums.length; i++){
            if(res[i] == 0){
                return i+1;
            }
        }
        return nums.length+1;
        
    }
}