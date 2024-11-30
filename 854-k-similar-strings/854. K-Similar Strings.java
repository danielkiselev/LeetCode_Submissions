class Solution {
    
    
    private int trav(char[] c1, char[] c2,int counter, int index, int max){
        if(max<=counter){
            return max;
        }
        else if(index>=c1.length){
            return counter;
        }
        else if(c1[index] == c2[index]){
            return trav(c1,c2,counter, index+1,max);
        }
        char target = c2[index];
        for(int i = index+1; i<c1.length; i++){
            if(c1[i] == target){
                char[] c1Clone = c1.clone();
                c1Clone[i] = c1[index];
                c1Clone[index] = target;
                int temp = trav(c1Clone,c2,counter+1, index+1,max);
                if(max>temp){
                    max = temp;
                }
            }
        }
        return max;
    }
    
    
    public int kSimilarity(String s1, String s2) {
        char [] c1 = s1.toCharArray(); 
        char [] c2 = s2.toCharArray(); 
        return trav(c1,c2,0,0, Integer.MAX_VALUE);
        
    }
}