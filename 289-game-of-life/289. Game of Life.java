class Solution {
    int[][] resBoard;
    public void gameOfLife(int[][] board) {
        resBoard = new int[board.length][board[0].length];
        resBoard = board.clone();
        for(int y = 0; y<board.length; y++){
            for(int x = 0; x<board[0].length; x++){
                board[y][x] = update(y, x);
            }
        }
        
        
        /*
Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
        */
    }
    
    public int update(int y, int x){
        int live = 0;
        Boolean currStatus;
        if(resBoard[y][x] == 1){
            currStatus = true;
        }
        else{
            currStatus = false;
        }
        
        
        if(y>0){
            if(resBoard[y-1][x] == 1){
                live++;
            }
            if(x>0){
                if(resBoard[y-1][x-1] == 1){
                    live++;
                }
            }
            if(x+1<resBoard[0].length){
                if(resBoard[y-1][x+1] == 1){
                    live++;
                }
            }
        }
        if(y+1<resBoard.length){
            if(resBoard[y+1][x] == 1){
                live++;
            }
            if(x>0){
                if(resBoard[y+1][x-1] == 1){
                    live++;
                }
            }
            if(x+1<resBoard[0].length){
                if(resBoard[y+1][x+1] == 1){
                    live++;
                }
            }
        }
        if(x>0){
            if(resBoard[y][x-1] == 1){
                live++;
            }
        }
        if(x+1<resBoard[0].length){
            if(resBoard[y][x+1] == 1){
                live++;
            }
        }
        System.out.println("y:" +y+ "  | x:"+x+  "   |live count"+live);
        if(live == 3){
            return 1;
        }
        if(currStatus){
            if(live == 2){
                return 1;
            }
        }
        return 0;
    }
}