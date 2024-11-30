class Solution {
    public boolean isHappy(int n) {
        String curr = Integer.toString(n);
        HashSet <Integer> data = new HashSet<Integer>();
        while(n<Integer.MAX_VALUE){
            int total = 0;
            for(int i = 0; i<curr.length(); i++){
                int local = Integer.parseInt(curr.substring(i, i+1));
                
                try{
                    total+=local*local;
                }
                catch(Exception e){
                    return false;
                }
            }
            if (data.contains(total)){
                return false;
            }
            data.add(total);
            if (total == 1){
                return true;
            }
            n = total;
            curr = Integer.toString(n);

            
        
        }
        
        return false;
    }
}