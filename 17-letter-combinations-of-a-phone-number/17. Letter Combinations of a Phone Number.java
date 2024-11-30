class Solution {
    HashMap<String,String[]> hm = new HashMap<String,String[]>();
    String digits;
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            ArrayList <String> res = new ArrayList <String>();
            return res;
        }
        this.digits = digits;
        String [] s2 = {"a","b","c"};
        hm.put("2",s2);
        String [] s3 = {"d","e","f"};
        hm.put("3",s3);
        String [] s4 = {"g","h","i"};
        hm.put("4",s4);
        String [] s5 = {"j","k","l"};
        hm.put("5",s5);
        String [] s6 = {"m","n","o"};
        hm.put("6",s6);
        String [] s7 = {"p","q","r","s"};
        hm.put("7",s7);
        String [] s8 = {"t","u","v"};
        hm.put("8",s8);
        String [] s9 = {"w","x","y","z"};
        hm.put("9",s9);

        return combine(0, "");
    }
    
    private List<String> combine(int index, String curr){
        String [] vals = hm.get(digits.substring(index, index+1));
        ArrayList <String> res = new ArrayList <String>();
        for(int i = 0; i<vals.length; i++){
            StringBuilder sb = new StringBuilder(curr);
            sb.append(vals[i]);
            if(index+1<digits.length()){
                for(String s : combine(index+1, sb.toString())){
                    res.add(s);
                }
            }
            else{
                res.add(sb.toString());
            }
        }
        return res;
    }
}