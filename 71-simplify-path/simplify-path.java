class Solution {
    public String simplifyPath(String path) {
        ArrayDeque<String> entry = new ArrayDeque<String>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<path.length();i++){
            char curr = path.charAt(i);
            if(curr == '/'){
                if(sb.length()>0){
                    String checkEntry = sb.toString();
                    if(checkEntry.equals("..")){
                        entry.pollFirst();
                    }
                    else if(checkEntry.equals(".")){
                    
                    }
                    else{
                        entry.push(checkEntry);
                    }
                    sb = new StringBuilder();
                }

            }else{
                sb.append(curr);
            }
        }
        if(sb.length()>0){
            String checkEntry = sb.toString();
            if(checkEntry.equals("..")){
                entry.pollFirst();
            }
            else if(checkEntry.equals(".")){
            
            }
            else{
                entry.push(checkEntry);
            }
        }
        StringBuilder res = new StringBuilder();
        while(!entry.isEmpty()){
            res.append("/");
            res.append(entry.pollLast());
        }
        if(res.isEmpty()){
            return "/";
        }
        return res.toString();
    }
}