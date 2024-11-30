class Solution {
    public String addBinary(String a, String b) {
        
        int szA = a.length();
        int szB = b.length();
        boolean procCarry = false;
        StringBuilder sb = new StringBuilder();
        if (szA>szB){
            for(int i = 1; i<=szA; i++){
                int counter = 0;
                if (procCarry){
                    counter = 1;
                    procCarry = false;
                }
                char currA = a.charAt(szA-i);
                char currB = '0';
                if(szB-i>=0){
                    currB = b.charAt(szB-i);
                }
                if (currB == '1'){
                    counter++;
                }
                if (currA == '1'){
                    counter++;
                }
                if(counter>=2){
                    counter-=2;
                    procCarry = true;
                }
                sb.append(Integer.toString(counter));
            }
        }
        else{
            for(int i = 1; i<=szB; i++){
                int counter = 0;
                if (procCarry){
                    counter = 1;
                    procCarry = false;
                }
                char currB = b.charAt(szB-i);
                char currA = '0';
                if(szA-i>=0){
                    currA = a.charAt(szA-i);
                }
                if (currB == '1'){
                    counter++;
                }
                if (currA == '1'){
                    counter++;
                }
                if(counter>=2){
                    counter-=2;
                    procCarry = true;
                }
                sb.append(Integer.toString(counter));
            }
        }
        if (procCarry){
            sb.append("1");
        }
        sb.reverse();
        return sb.toString();

        
    }
}