class Solution {
    public void nextPermutation(int[] nums) {
        int max = 0;
        for(int i =1; i<nums.length; i++){
            if(nums[i]>nums[max]){
                max = i;
            }
        }
        if(max != 0){
            int temp = nums[max-1];
            nums[max-1] = nums[max];
            nums[max] = temp;
        }
        else{
            Arrays.sort(nums);
        }
        
    }
}