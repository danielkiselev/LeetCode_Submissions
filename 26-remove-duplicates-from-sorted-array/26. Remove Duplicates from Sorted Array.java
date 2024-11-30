class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int prev = nums[0];
        int index = 0;
        for(int i = 1; i<nums.length; i++){
            int curr = nums[i];
            if(prev == curr){}
            else{
                index++;
                nums[index] = curr;
                prev = curr;
            }
        }
        return (index+1);
    }
}