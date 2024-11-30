class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        if(l1 == 0){
            return nums1;
        }
        if(l2 == 0){
            return nums2;
        }
        int c1 = 0;
        int c2 = 0;
        ArrayList <Integer> alist = new ArrayList <Integer> ();
        HashMap <Integer, Integer> hm = new HashMap <Integer, Integer>();
        for(int i = 0; i<l1; i++){
            if(hm.containsKey(nums1[i])){
                hm.put(nums1[i],hm.get(nums1[i])+1);
            }
            else{
                hm.put(nums1[i],1);
            }
            
        }
        for(int i = 0; i<l2; i++){
            if(hm.containsKey(nums2[i])){
                if(hm.get(nums2[i]) == 0){

                }
                else{
                    alist.add(nums2[i]);
                    hm.put(nums2[i], hm.get(nums2[i])-1);
                }
            }
        }
        int [] res = new int[alist.size()];
        int index = 0;
        for(Integer i: alist){
            res[index] = i;
            index++;
        }
        return res;
    }
}