class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> sumCount = new HashMap<Integer, Integer>();
        sumCount.put(0,1);
        int res = 0;
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            int curr = nums[i];
            sum+=curr;
            int offSet = sum-k;
            if(sumCount.containsKey(offSet)){
                res+=sumCount.get(offSet);
            }
            int occurance = 1;
            if(sumCount.containsKey(sum)){
                occurance+=sumCount.get(sum);
            }
            sumCount.put(sum, occurance);
        }
        return res;
    }
}