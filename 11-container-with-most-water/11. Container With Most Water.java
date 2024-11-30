class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int lIndex = 0;
        int rIndex = height.length-1;
        while(rIndex>lIndex){
                int width = rIndex - lIndex;
                int area;
                if(height[rIndex]<height[lIndex]){
                    area = width*(height[rIndex]);
                    rIndex--;
                }
                else{
                    area = width*(height[lIndex]);
                    lIndex++;
                }
                if(area>max){
                    max = area;
                }
            }
        return max;
    }
}