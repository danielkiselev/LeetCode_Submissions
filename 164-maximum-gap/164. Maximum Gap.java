class Solution {
    public int maximumGap(int[] nums) {
        int res= 0;
        if(nums.length <2){
            return res;
        }
        TreeSet<Integer> sorted = new TreeSet<Integer> ();
        for(int i = 0; i<nums.length; i++){
            sorted.add(nums[i]);
        }
        Integer []nums2 = sorted.toArray(new Integer[sorted.size()]);
        Integer prev = nums2[0];
        for(int i = 1; i<nums2.length; i++){
            res = Math.max(nums2[i]-prev,res);
            prev = nums2[i];
        }
        return res;
        
    }
}