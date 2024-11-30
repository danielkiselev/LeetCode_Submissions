class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue <Integer> queue = new PriorityQueue <Integer>(new revComp());
        for(int i = 0; i<nums.length; i++ ){
            queue.add(nums[i]);
        }
        for(int i = 0; i<k; i++ ){
            if(i+1<k){
                queue.poll();
            }
            else{
                return queue.peek();
            }
        }
        return 0;
    }
    
    class revComp implements Comparator<Integer>{ 
        public int compare(Integer i1, Integer i2) {
            if (i1 < i2) {
                return 1; 
            }
            else if (i1>i2){
                return -1; 
            }
            return 0; 
        }
    }
}