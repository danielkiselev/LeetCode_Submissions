class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1Off = 1;
        int index2Off = 1;
        if(n == 0){}
        else if(m==0){
            for(int i = 0; i<n; i++){
                nums1[i] = nums2[i];
            }
        }
        else if(m>0 ){
            for(int i = m+n-1; i>=0;i--){
                if(nums1[m-index1Off]<nums2[n-index2Off]){
                    nums1[i] = nums2[n-index2Off];
                    if(n-index2Off == 0){
                        break;
                    }
                    index2Off++;
                }
                else{
                    nums1[i] = nums1[m-index1Off];
                    if(m-index1Off == 0){
                        for(int k = 0; k<=n-index2Off; k++){
                            nums1[k] = nums2[k];
                        }
                        break;
                    }
                    index1Off++;
                }
            }
        }
    }
}