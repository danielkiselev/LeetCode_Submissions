class Solution {
    public int islandPerimeter(int[][] grid) {
        int x = grid[0].length;
        int y = grid.length;
        int totalPer = 0;
        for(int i = 0; i<x; i++){
            for(int z = 0; z<y; z++){
                if(grid[z][i]==1){
                    int tempPer = 4;
                    if(z!=0){
                        if(grid[z-1][i]==1){
                            tempPer--;
                        }
                    }
                    if(z!=y-1){
                        if(grid[z+1][i]==1){
                            tempPer--;
                        }
                    }
                    
                    if(i!=0){
                        if(grid[z][i-1]==1){
                            tempPer--;
                        }
                    }
                    if(i!=x-1){
                        if(grid[z][i+1]==1){
                            tempPer--;
                        }
                    }
                    totalPer +=tempPer;
                }
            }
        }
        return totalPer;
    }
}