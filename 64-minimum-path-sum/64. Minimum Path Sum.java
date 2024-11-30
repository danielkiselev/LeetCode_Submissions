class Solution {
    int [][] pathEnd;
    int[][] grid;
    public int minPathSum(int[][] grid) {
        this.grid = grid;
        pathEnd = new int [grid.length][grid[0].length];
        for(int y = 0; y<grid.length; y++){
            for(int x = 0; x<grid[0].length; x++){
                pathEnd[y][x] = Integer.MAX_VALUE;
            }
        }
        updateNeighbors(grid.length-1,grid[0].length-1,0);
        return pathEnd[0][0];
        
        
    }
    
    private void updateNeighbors(int y, int x, int parentVal){
        if((parentVal+grid[y][x])<pathEnd[y][x]){
            pathEnd[y][x] = (parentVal+grid[y][x]);
        }
        else{
            return;
        }
        if(x>0){
            updateNeighbors(y, x-1, pathEnd[y][x]);
        }
        if(y>0){
            updateNeighbors(y-1, x, pathEnd[y][x]);
        }
    }
}