class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = nums.length-1; i>=0; i--){
            if(list.contains(nums[i])){
                
            }
            else{
                list.add(nums[i]);
                if(list.size()==3){
                    return list.get(2);
                }
            }
        }
        if(list.size()>=1){
            return list.get(0);
        }
        return 0;
    }
}