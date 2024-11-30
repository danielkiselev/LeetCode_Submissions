class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        String prev = "";
        HashMap <String, Integer> values = new HashMap <String, Integer>();
        values.put("I",1);
        values.put("V",5);
        values.put("X",10);
        values.put("L",50);
        values.put("C",100);
        values.put("D",500);
        values.put("M",1000);
        for(int i = 0; i<s.length(); i++){
            String curr = s.substring(i, i+1);
            sum+=values.get(curr);
            if(curr.equals("V")||curr.equals("X")){
                if(prev.equals("I")){
                    sum-=2;
                }
            }
            else if(curr.equals("L")||curr.equals("C")){
                if(prev.equals("X")){
                    sum-=20;
                }
            }
            else if(curr.equals("D")||curr.equals("M")){
                if(prev.equals("C")){
                    sum-=200;
                }
            }
            prev = curr;
        }
        return sum;
    }
}