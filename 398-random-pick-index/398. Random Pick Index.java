class Solution {
    HashMap<Integer, ArrayList<Integer>> data = new HashMap<Integer, ArrayList<Integer>>();

    public Solution(int[] nums) {
        for(int i = 0 ; i<nums.length; i++){
            ArrayList <Integer> locList  = new  ArrayList <Integer>();
            if (data.containsKey(nums[i])){
                locList = data.get(nums[i]);
            }
            locList.add(i);
            data.put(nums[i],locList);
        }
    }
    
    public int pick(int target) {
        ArrayList <Integer> values = data.get(target);
 
        return values.get(0);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */