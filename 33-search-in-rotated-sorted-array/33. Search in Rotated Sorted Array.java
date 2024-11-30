class Solution {
    public int search(int[] nums, int target) {
        int sz = nums.length;
        if(sz==0){
            return -1;
        }
        if(sz == 1){
            if(nums[0]==target){
                return 0;
            }
            else{
                return -1;
            }
        }
        if(sz==2){
            if(nums[0]==target){
                return 0;
            }
            else if(nums[1]==target){
                return 1;
            }
            return -1;
        }
        int start = nums[0];
        int end = nums[sz-1];
        int mid = nums[(sz/2)];
        if(target>=start|| target<mid){
            if(target>mid){
                for(int i = 0; i<=(sz/2);i++ ){
                    if(nums[i]==target){
                        return i;
                    }
                }
            }else{
                for(int i = (sz/2); i<sz;i++ ){
                    if(nums[i]==target){
                        return i;
                    }
                }
            }

            }
                for(int i = 0; i<sz;i++ ){
                    if(nums[i]==target){
                        return i;
                    }
                }
            
            return -1;
        }
        
    }