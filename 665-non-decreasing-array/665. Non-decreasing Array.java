class Solution {
    public boolean checkPossibility(int[] nums) {
        int lastVal = nums[nums.length-1];
        int count = 0;
        for(int i = nums.length-2; i>=0;i--){
            if(nums[i]<=lastVal){
                lastVal = nums[i];
                continue;
            }
            else{
                count++;
                lastVal = nums[i+1];
                if(count>=2){
                    return false;
                }
            }
        }
        return true;
        
    }
}