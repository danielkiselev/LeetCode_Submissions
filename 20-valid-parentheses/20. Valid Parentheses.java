class Solution {
    public boolean isValid(String s) {
        if(s == null){
            return false;
        }
        if(s.equals("")){
            return true;
        }
        if(s.length()%2 == 1){
            return false;
        }
        ArrayDeque <String> stack = new ArrayDeque <String>();
        HashMap<String, String> convMap = new HashMap<String, String>();
        convMap.put("[", "]");
        convMap.put("(", ")");
        convMap.put("{", "}");
        if(convMap.containsKey(s.substring(0,1))){
            stack.push(convMap.get(s.substring(0,1)));
        }
        else{
            return false;
        }
        for(int i = 1; i<s.length(); i++){
            String curr = s.substring(i, i+1);
            if(convMap.containsKey(curr)){
                stack.push(convMap.get(curr));
            }else{
                if(!stack.isEmpty()){
                    String top = stack.peek();
                    if(curr.equals(top)){
                        stack.pop();
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}