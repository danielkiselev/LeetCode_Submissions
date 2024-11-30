class Solution {
    
    int subsetVal;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for(int i = 0; i<nums.length;i++){
            total+=nums[i];
        }
        if(total%k != 0){
            return false;
        }
        subsetVal = total/k;
        if(nums[nums.length-1]>subsetVal){
            return false;
        }
        return dfs(nums, 0, 0, subsetVal, k);
    }
    
 private  boolean dfs(int [] nums,int startIndex, int currentSum, int target, int pairsToFind){
	 
	if(pairsToFind==0){
		return true;
	}
	
	 if(currentSum==target){
		 return dfs(nums,  0, 0, target, pairsToFind-1);
		 
	 }
	 
	 for(int i=startIndex;i<nums.length;i++){
		 int curr = nums[i];
		 nums[i]=0;
		 if(dfs(nums,i+1,currentSum+curr,target,pairsToFind)){
			 return true;
		 }
		 nums[i]=curr;
	 }
	 return false;
 }
    
}