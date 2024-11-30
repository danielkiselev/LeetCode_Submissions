class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int [] res = new int[nums1.length];
        HashMap<Integer, Integer>hm = new HashMap<Integer, Integer>();
        for(int i = 0; i<nums2.length; i++){
            hm.put(nums2[i],i);
        }
        for(int i = 0; i<nums1.length; i++){
            res[i] = -1;
            for(int z = hm.get(nums1[i])+1; z<nums2.length; z++){
                if(nums1[i]<nums2[z]){
                    res[i] = nums2[z];
                    break;
                }
            }
        }
        return res;
    }
}