class Solution {
    public int[] twoSum(int[] nums, int target) {
    int[] res = new int[2];
    Integer[] visited = new Integer[3000+1];
    int numSize = nums.length;
    for(int i = 0; i < numSize; i++){
        // if(nums[i]>target){
        //     return res;
        // }
        if(visited[nums[i]+1000] != null){
            res[0] = visited[nums[i]+1000];
            res[1] = i+1;
            return res;
        }
        int temp = target-nums[i];
        if(temp<nums[i]){
            return res;
        }
        visited[temp+1000]=i+1;
    }
    return res;
    //code here
    }
}