class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length<1){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(true){
            String curr = null;
            for(int i = 0; i<strs.length; i++){
                String local;
                try{
                    local = strs[i].substring(index, index+1);
                }
                catch(Exception e){
                    return sb.toString();
                }
                if(curr == null){
                    curr = local;
                }
                else if(!curr.equals(local)){
                    return sb.toString();
                }
            }
            index++;
            sb.append(curr);
            curr = null;
        }
    }
}