class Solution {
    public String simplifyPath(String path) {
        ArrayDeque<String> entry = new ArrayDeque<String>();
        StringBuilder sb = new StringBuilder();
        char[] pathChars = path.toCharArray();
        for(int i = 0; i<path.length();i++){
            char curr = pathChars[i];
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
        sb = new StringBuilder();
        while(!entry.isEmpty()){
            sb.append("/");
            sb.append(entry.pollLast());
        }
        if(sb.isEmpty()){
            return "/";
        }
        return sb.toString();
    }
}