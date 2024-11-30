class Solution {
    public int search(int[] nums, int target) {
        for(Integer i =nums.length-1; i>=0; i--){
        int o= nums[i];
        if(o<target){
            return -1;
        }
        else if(o == target){
            return i;
        }
        else{
            continue;
        }
    }
    return -1;
    }
}