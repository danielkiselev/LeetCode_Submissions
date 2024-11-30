class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums.length == 0){
            return nums;
        }
        HashSet<Integer> data = new HashSet<Integer>();
        for(int i = 0; i<nums.length; i++){
            data.add(nums[i]);
        }
        
        for(int i = 0; i<nums.length; i++){
            if(data.contains(nums[i]+1)){
                nums[i] = nums[i]+1;
            }
            else{
                nums[i] = -1;
            }
        }
        return nums;
    }
}