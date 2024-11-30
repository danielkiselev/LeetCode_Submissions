class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        HashSet<Integer> hm = new HashSet<Integer>();
        for(int i = 0; i<candidates.length; i++){
            hm.add(candidates[i]);
        }
        for(int i = 0; i<candidates.length; i++){
            if(candidates[i]<=target){
                int curr = candidates[i];
                while(curr <= target){
                    int loc = target%curr;
                    if(loc == 0){
                        ArrayList<Integer> locL= new ArrayList<Integer>();
                        for(int z = 0; z<(target/candidates[i]); z++){
                            locL.add(candidates[i]);
                        }
                        res.add(locL);
                    }
                    else if(hm.contains(loc)){
                        ArrayList<Integer> locL= new ArrayList<Integer>();
                        locL.add(loc);
                        for(int z = 0; z<(curr/candidates[i]); z++){
                            locL.add(candidates[i]);
                        }
                        res.add(locL);
                    }
                    curr+=candidates[i];
                }

            }
        }
        return res;
        
    }
}