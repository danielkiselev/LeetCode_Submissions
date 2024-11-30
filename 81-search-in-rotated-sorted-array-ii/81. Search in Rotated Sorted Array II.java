class Solution {
    public boolean search(int[] nums, int target) {
                int sz = nums.length;
        if(sz==0){
            return false;
        }
        if(sz == 1){
            if(nums[0]==target){
                return true;
            }
            else{
                return false;
            }
        }
        if(sz==2){
            if(nums[0]==target){
                return true;
            }
            else if(nums[1]==target){
                return true;
            }
            return false;
        }
        int start = nums[0];
        int end = nums[sz-1];
        int mid = nums[(sz/2)];
        if(target>=start|| target<mid){
            if(target>mid){
                for(int i = 0; i<=(sz/2);i++ ){
                    if(nums[i]==target){
                        return true;
                    }
                }
            }else{
                for(int i = (sz/2); i<sz;i++ ){
                    if(nums[i]==target){
                        return true;
                    }
                }
            }

            }
                for(int i = 0; i<sz;i++ ){
                    if(nums[i]==target){
                        return true;
                    }
                }
            
            return false;
        }
    }

