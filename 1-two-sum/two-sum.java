class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] resArray = new int[2];
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i=0; i<nums.length; i++){
            if(hm.containsKey(nums[i])){
                resArray[0]=hm.get(nums[i]);
                resArray[1]=i;
                return resArray;
            }else{
                int res = target-nums[i];
                hm.put(res, i);
            }
        }
        return resArray;
    }
}