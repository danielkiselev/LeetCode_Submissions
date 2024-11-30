class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length < 3){
            int max = 0;
            for(int i = 1; i<nums.length; i++){
                if(nums[i]>nums[max]){
                    max = i;
                }
            }
            return max;
        }
        else{
            int max = 0;
            for(int i = 0; i<nums.length-2; i++){
                int val1 = nums[i];
                int val2 = nums[i+1];
                int val3 = nums[i+2];
                if(val1<val2 && val3<val2){
                    return i+1;
                }
                else{
                    if(nums[i]>nums[max]){
                        max = i;
                    }
                    if(nums[i+1]>nums[max]){
                        max = i+1;
                    }
                    if(nums[i+2]>nums[max]){
                        max = i+2;
                    }
                }
                if((i+1) == (nums.length-2)){
                    return max;
                }
                
            }
        }
        return 0;
    }
}