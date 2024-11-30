class NumMatrix {

    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    
    public void update(int row, int col, int val) {
        matrix[row][col] = val;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = 0;
        for(int y = row1; y<=row2; y++){
            for(int x = col1; x<=col2; x++){
                total+=matrix[y][x];
            }
        }
        return total;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */