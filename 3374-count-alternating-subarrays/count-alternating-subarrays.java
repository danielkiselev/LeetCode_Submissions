class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        int prev = nums[0];
        long count = 1;
        long ref = 1;
        for(int i =1; i<nums.length;i++){
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