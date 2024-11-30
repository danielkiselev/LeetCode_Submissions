class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int w = matrix[0].length;
        int h = matrix.length;
        if(h == 1){
            return matrix[0][k-1];
        }
        int y = (k/w);
        int extra = (k-y*(w));
        if(extra == 0){
            return matrix[y-1][w-1];
        }
        return matrix[y][extra-1];
        
    }
}