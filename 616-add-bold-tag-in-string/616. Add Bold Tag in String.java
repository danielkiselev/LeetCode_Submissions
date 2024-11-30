class Solution {
    public String addBoldTag(String s, String[] dict) {

        boolean [] bold = new boolean [s.length()];
        for(int i = 0; i<s.length(); i++){
           for(String z : dict){
               if(i+z.length()>s.length()){
                   continue;
               }
               if(s.substring(i, i+z.length()).equals(z)){
                   for(int x = i; x<i+z.length(); x++){
                       bold[x] = true;
                   }
               }
           }
        }
        StringBuilder res = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            if(bold[i]){
                sb.append(s.substring(i,i+1));
            }
            else{
                if(sb.length()>0){
                    res.append("<b>");
                    res.append(sb.toString());
                    sb.toString();
                    res.append("</b>");
                    sb = new StringBuilder();  
                }
                res.append(s.substring(i, i+1));
            }
        }
                        if(sb.length()>0){
                    res.append("<b>");
                    res.append(sb.toString());
                    sb.toString();
                    res.append("</b>");
                    sb = new StringBuilder();  
                }
        return res.toString();
    }
}