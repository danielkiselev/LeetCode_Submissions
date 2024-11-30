class Solution {
    public String addStrings(String num1, String num2) {
        int sz = 0;
        if(num1.length()>num2.length()){
            sz = num1.length();
        }
        else{
            sz = num2.length();
        }
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<sz; i++){
            int val1 = 0;
            int val2 = 0;
            if(i<num1.length()){
                val1 = Integer.parseInt(num1.substring((num1.length()-1)-i,(num1.length())-i));
            }
            if(i<num2.length()){
                val2 = Integer.parseInt(num2.substring((num2.length()-1)-i,(num2.length())-i));
            }
            int res = val1+val2+carry;
            carry = 0;
            if(9<(res))
            {
                res-=10;
                carry++;
            }
            sb.append(res);
        }
        if(carry>0)
        {
            sb.append(carry);
        }
        sb.reverse();
        return sb.toString();
    }
}