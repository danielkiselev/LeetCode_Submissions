class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
        for(int i = 0; i<nums.length; i++){
            data.put(nums[i], 1);
        }
        int max = 0;
        for(Integer val : data.keySet()){
            int count = data.get(val);
            if(count>max){
                max = count;
            }
            int low = val-1;
            int high = val+1;
            if(data.containsKey(low)){
                int locCount = count+data.get(low);
                data.put(low, locCount);
            }
            if(data.containsKey(high)){
                int locCount = count+data.get(high);
                data.put(high, locCount);
            }
        }
        return max;
        
    }
}