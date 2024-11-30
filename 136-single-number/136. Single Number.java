class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i<nums.length-1; i+=2){
            if(nums[i] == nums[i+1]){
            }
            else{
                if(i>0){
                    if(nums[i-1] == nums[i]){
                        return nums[i+1];
                    }
                }
                if(i+2<nums.length){
                    if(nums[i+1] == nums[i+2]){
                        return nums[i];
                    }
                }
            }
        }
        return nums[nums.length-1];
    }
}