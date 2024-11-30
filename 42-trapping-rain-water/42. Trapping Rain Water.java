class Solution {
    public int trap(int[] height) {
        int sz = height.length;
        int left[] = new int[sz];
        int right[] = new int[sz];
        int lMax = 0;
        int rMax = 0;
        int counter = 0;
        for(int i =0; i<sz;i++){
            if(height[i]>lMax){
                lMax = height[i];
            }
            left[i] = lMax;
        }
        for(int i =sz-1; i>=0;i--){
            if(height[i]>rMax){
                rMax = height[i];
            }
            right[i] = rMax;
            if(right[i]>left[i]){
                right[i] = left[i];
            }
            
        }
        for(int i =0; i<sz;i++){
            counter += right[i]-height[i];
        }
        return counter;
    }
}