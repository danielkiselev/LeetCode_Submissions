class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int open = 0; 
        int close =  0;
        for(int i = 0;  i<s.length(); i++){
            String curr = s.substring(i, i+1);
            if(curr.equals("(")){
                open++;
            }
            else if(curr.equals(")")){
                if(open>0){
                    open--;
                }
                else{
                    close++;
                }
            }
        }
        HashSet<String> res  = new HashSet<String>();
                        HashSet<String> temp  = new HashSet<String>();
        ArrayList<String> resL = new ArrayList<String>();
        temp = trav(res, open, close, 0, s);
        if(temp == null){
            resL.add("");
            return resL;
        }
        ArrayList<String> resL1 = new ArrayList<String>(res);
        return resL1;
        
    }
    
    
    private HashSet<String> trav(HashSet<String> res, int open, int close, int index, String s){
        if(open == 0 && close == 0){
            if(check(s)){
                res.add(s);
                return res;
            }
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = index;  i<s.length(); i++){
            String curr = s.substring(i, i+1);
            if(curr.equals("(") &&  open>0){
                sb.append(s.substring(0,i));
                if(i<s.length()-1){
                    sb.append(s.substring(i+1,s.length()));
                }
                HashSet<String> temp  = new HashSet<String>();
                temp = trav(res, open-1, close, i, sb.toString());
                if(temp == null){
                    return res;
                }
                sb = new StringBuilder();
            }
            else if(curr.equals(")") &&  close>0){

                sb.append(s.substring(0,i));
                if(i<s.length()-1){
                    sb.append(s.substring(i+1,s.length()));
                }
                HashSet<String> temp  = new HashSet<String>();
                temp = trav(res, open, close-1, i, sb.toString());
                if(temp == null){
                    return res;
                }
                sb = new StringBuilder();
            
            }
        }
        return res;
    }
    
    
    private boolean check(String s){
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        for(int i = 0;  i<s.length(); i++){
            String curr = s.substring(i, i+1);
            if(curr.equals("(")){
                stack.push(i);
            }
            else if(curr.equals(")")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}

/*


(a)())()

(a)()_()  
(a)(_)()
(a_())() 

(a)()()
(a)()()
(a())() 

*/