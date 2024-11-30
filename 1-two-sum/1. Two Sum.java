class Solution {
    public int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];
        HashMap<Integer, Integer> data = new HashMap<Integer, Integer> ();
        for(int i = 0; i<nums.length; i++){
            if(data.containsKey(nums[i])){
                res[0] = data.get(nums[i]);
                res[1] = i;
                return res;
            }
            data.put(target-nums[i],i);
        }
        return res;
    }
}