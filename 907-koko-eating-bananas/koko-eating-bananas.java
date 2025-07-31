class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;
        for(int i:piles){
            if(i>right){
                right = i;//set to max of array
            }
        }
        int res = right;
        while(left<right){
            int middle  = (left+right)/2;
            int hours = 0;
            for(int i:piles){
                hours+= (int)Math.ceil((double)i/middle);
            }
            if(hours<=h){
                right = middle;
            }
            else{
                left = middle+1;
            }
            System.out.println(left+" "+ right+" "+middle);

        }


        return right;

        
    }
}