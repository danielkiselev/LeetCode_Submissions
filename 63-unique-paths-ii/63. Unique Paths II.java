class Solution {
    int xSz;
    int ySz;
    int input [][];
    HashMap <Integer,Integer> grid  = new HashMap<Integer,Integer>();
    
    public Integer uniquePathsWithObstacles(int[][] obstacleGrid) {
        input = obstacleGrid;
        xSz = input[0].length;
        ySz = input.length;
        if(xSz == 0 && ySz == 0){
            return 0;
        }
        if(input[0][0]==1){
            return 0;
        }
        if(input[ySz-1][xSz-1]==1){
            return 0;
        }
        if(xSz*ySz==1){
            if(input[0][0]==0){
                return 1;
            }
        }
        grid.put(xSz*ySz, 1);
        traverse(0,0);
        return grid.get(1);

    }
    
    public void traverse(int yIndex, int xIndex){
        int curr;
        curr = (yIndex*xSz + (xIndex+1));
        grid.put(curr,0);
        if(xIndex+1<xSz){
            if(input[yIndex][xIndex+1] == 0){
                if(!grid.containsKey(curr+1)){
                    traverse(yIndex, xIndex+1);
                }
                grid.put(curr,grid.get(curr)+grid.get(curr+1));
            }
        }
        if(yIndex+1<ySz){
            if(input[yIndex+1][xIndex] == 0){
                if(!grid.containsKey(curr+xSz)){
                    traverse(yIndex+1,xIndex);
                }
                grid.put(curr,grid.get(curr)+grid.get(curr+xSz));
            }
        }
    }
}
