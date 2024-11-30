class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int counter = 0;
        int index = 0;
        for(int r = 0; r<rows; r++ ){
            for(int c = 0; c<cols; c++ ){
                if((sentence[index].length()+c)<=cols){
                    c+=sentence[index].length();
                    index++;
                }
                else{
                    break;
                }
                if(index == sentence.length){
                    index = 0;
                    counter++;
                }
            }
        }
        return counter;
            
        
    }
}