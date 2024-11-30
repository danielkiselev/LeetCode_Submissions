class Solution {
    String s;
    int sz;
    ArrayList<List<String>> res = new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
        try{
            this.s = s;
        }
        catch(Exception e){
            return res;
        }
        sz = s.length();
        if(sz == 1){
            ArrayList<String> palindrome = new ArrayList<String>();
            palindrome.add(s);
            res.add(palindrome);
            return res;
        }
        ArrayList<String> palindrome = new ArrayList<String>();
        StringBuilder start = new StringBuilder();
        StringBuilder remain = new StringBuilder(s);
        segment("", s,palindrome);
        return res;
        
    }
    
    private void segment(String currS, String remainS,ArrayList<String> palindrome){
        StringBuilder curr = new StringBuilder(currS);
        StringBuilder remain = new StringBuilder(remainS);
            System.out.println("pre-curr: "+curr.toString());
            System.out.println("pre-remain: "+remain.toString());
        if(remain.length() == 0){
            /*
            if(check(curr.toString())){
                palindrome.add(curr.toString());
            }
            */
            if(!palindrome.isEmpty()){
                res.add(palindrome);
            }
            
        }
        else{

            curr.append(remain.charAt(0));
            remain.deleteCharAt(0);
            System.out.println("post-curr: "+curr.toString());
            System.out.println("post-remain: "+remain.toString());
            if(check(curr.toString())){
                palindrome.add(curr.toString());
            }
            ArrayList<String> temp = new ArrayList<String>();
            segment(curr.toString(), remain.toString(), temp);
            segment("", remain.toString(), palindrome);
            
            
        }

    }
    
    private boolean check(String input){
        if(input.length() == 0){
            return false;
        }
        System.out.println("checking "+ input);
        int sz = input.length();
        for(int i = 0; i<(sz+1)/2; i++ ){
            if(i+1 == sz){
                return true;
            }
            if(input.charAt(i) == input.charAt((sz-1)-i)){
                
            }
            else{
                return false;
            }
        }
        return true;
    }
}