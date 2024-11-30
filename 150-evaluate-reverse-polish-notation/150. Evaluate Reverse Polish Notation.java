class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 0){
            return 0;
        }
        ArrayDeque <Integer> data = new ArrayDeque <Integer>();
        for(int i = 0; i<tokens.length; i++){
            String curr = tokens[i];
            if(curr.equals("+")){
                int v2 = data.pop();
                int v1 = data.pop();
                data.push(v1+v2);
            }
            else if(curr.equals("-")){
                int v2 = data.pop();
                int v1 = data.pop();
                data.push(v1-v2);
            }
            else if(curr.equals("/")){
                int v2 = data.pop();
                int v1 = data.pop();
                data.push(v1/v2);
            }
            else if(curr.equals("*")){
                int v2 = data.pop();
                int v1 = data.pop();
                data.push(v1*v2);
            }
            else{
                int loc = Integer.parseInt(curr);
                data.push(loc);
            }
        }
        return data.pop();
            
        
    }
}