class Solution {
    int rowIndex;
    public List<Integer> getRow(int rowIndex) {
        this.rowIndex = rowIndex;

        
        ArrayList <Integer> row = new ArrayList<Integer>();
        row.add(1);
        if (rowIndex == 0){
            return row;
        }
        return res(0, row);
    }
    
    
    private ArrayList<Integer> res(int currIndex, List<Integer> curr){
        ArrayList <Integer> row = new ArrayList<Integer>();
        row.add(1);
        for(int i = 0; i<currIndex; i++){
            row.add(curr.get(i)+curr.get(i+1));
        }
        row.add(1);
        currIndex+=1;
        if(currIndex == rowIndex){
            return row;
        }
        else{
            return res(currIndex, row);
        }
    }
}