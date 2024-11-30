class Solution {
    public int kEmptySlots(int[] bulbs, int K) {
        HashSet<Integer> used = new HashSet<Integer>();
        if(bulbs.length<=K){
            return -1;
        }
        used.add(bulbs[0]);
        for(int i = 1; i<bulbs.length; i++){
            int curr = bulbs[i];
            int left = curr-(K+1);
            int right = curr+(K+1);
            if(K==0){
                if(used.contains(left)){
                    return i+1;
                }
                if(used.contains(right)){
                    return i+1;
                }
            }
            if(used.contains(left)){
                for(int l = left+1; l<curr; l++){
                    if(used.contains(l)){
                        break;
                    }
                    if(l == curr-1){
                        return i+1;
                    }
                }
                
            }
            if(used.contains(right)){
                for(int r = curr+1; r<right; r++){
                    if(used.contains(r)){
                        break;
                    }
                    if(r == right-1){
                        return i+1;
                    }
                }
                
            }
            used.add(curr);
        }
        return -1;
    }
}