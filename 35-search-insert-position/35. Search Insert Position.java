class Solution {
    public int searchInsert(int[] nums, int target) {
        int middle = Math.round(Math.floor((nums.length)/2));
        while(middle<nums.length){
            if(middle==0){
                if(nums[middle]>=target){
                    return 0;
                }
                else{
                    return 1;
                }
            }
            int middleVal = nums[middle];
            if(middleVal == target){
                return middle;
            }
            if(middleVal>target){
                middle = Math.round(middle/2);
                continue;
            }
            if(middleVal<target){
                if(middle+1<nums.length){
                    if(nums[middle+1]>target){
                        return middle+1;
                    }
                    else{
                        if(nums.length-middle>1){
                            middle = middle + Math.round((nums.length-middle)/2);
                        }
                        else{
                            return nums.length;
                        }
                    }
                }
                else{
                    return nums.length;
                }
            }
        }
        
        if(nums[middle]<target){
            return middle+1;
        }
        return 0;
    }
    
//     private boolean check(Integer lower, Integer upper, int target){
//         if(lower != null){
//             if target
//         }
        
//     }
    
}