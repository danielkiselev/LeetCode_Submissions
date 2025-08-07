class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        int prev = nums[0];
        long count = 0;
        long ref = 0;
        for(int i =0; i<nums.length;i++){
            if(nums[i]!=prev){
                ref += 1;
            }
            else{
                ref = 1;
            }
            count+=ref;
            prev=nums[i];
        }
        return count;
        
    }
}