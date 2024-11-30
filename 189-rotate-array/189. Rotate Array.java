class Solution {
    public void rotate(int[] nums, int k) {
        while(k>nums.length){
            k -=nums.length;
        }
            int [] res = new int [nums.length];
            for(int i = 0; i<nums.length; i++){
                res[i] = nums[i];
            }
            int index = 0;
            for(int i = ((nums.length)-k); i<nums.length; i++){
                nums[index] = res[i];
                index++;
            }
            for(int i =0 ; i<((nums.length)-k); i++){
                nums[index] = res[i];
                index++;
            }
    

    }
}