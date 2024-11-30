class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int counter = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 0){
                if(counter>max){
                    max = counter;
                }
                counter = 0;
            }
            else{
                counter++;
            }
        }
        if(counter>max){
            max = counter;
        }
        return max;
    }
}