class Solution {
    List<List<Integer>> triangle;
    public int minimumTotal(List<List<Integer>> triangle) {
        this.triangle = triangle;
        int size = triangle.size();
        return findNext(0, 0);
    }
    
    private int findNext(int layer, int index){
        if(layer >= triangle.size()){
            return Integer.MAX_VALUE-100;
        }
        List<Integer> finalLayer = triangle.get(layer);
        if(index < 0 || index > finalLayer.size()){
            return Integer.MAX_VALUE-100;
        }
        int val = finalLayer.get(index);
        if(layer+1 < triangle.size()){
            int opt1 = findNext(layer+1, index+1);
            int opt2 = findNext(layer+1, index);

            return val + Math.min(opt1, opt2);
        }
        return val;
    }
}