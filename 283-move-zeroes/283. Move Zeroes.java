class Solution {
    public void moveZeroes(int[] nums) {
        int counter = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 0){
                counter++;
            }
            else{
                nums[i-counter] = nums[i];
            }
        }
        for(int i = 1; i<=counter; i++){
            nums[nums.length-i] = 0;
        }
    }
}