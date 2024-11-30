class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1){
            return nums;
        }
        int resultSize = nums.length - k +1;
        int [] res = new int [resultSize];
        ArrayDeque<Integer> window = new ArrayDeque<Integer>();
        for(int i = 0; i<nums.length; i++){
                        if(!window.isEmpty() && i- window.getFirst()>=k){
                window.removeFirst();
            }
            while(!window.isEmpty() && nums[window.peekLast()]<nums[i]){
                window.removeLast();
            }

            window.add(i);
            if(i-(k-1)>=0){
                            res[i-(k-1)] = nums[window.getFirst()];


            }
        }
        return res;
        
        
    }
    

}