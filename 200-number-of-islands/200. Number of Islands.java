class Solution {
    int[][] visited;
    char[][] grid;
    public int numIslands(char[][] grid) {
        if (grid.length == 0){
            return 0;
        }
        this.grid = grid;
        visited = new int[grid.length][grid[0].length];
        int res = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    check(i, j);
                    res++;  
                }
            }
        }
        return res;
    }
    
    private void check(int i, int j){
        visited[i][j] = 1;
        if(i>0){
            if(grid[i-1][j] == '1' && visited[i-1][j] == 0){
                check(i-1, j);
            }   
        }
        if(i<grid.length-1){
            if(grid[i+1][j] == '1' && visited[i+1][j] == 0){
                check(i+1, j);
            }   
        }
        if(j>0){
            if(grid[i][j-1] == '1' && visited[i][j-1] == 0){
                check(i, j-1);
            }   
        }
        if(j<grid[0].length-1){
            if(grid[i][j+1] == '1' && visited[i][j+1] == 0){
                check(i, j+1);
            }   
        }
    }
}