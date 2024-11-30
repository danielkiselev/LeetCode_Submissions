class TicTacToe {

    /** Initialize your data structure here. */
        int [][] board;
    public TicTacToe(int n) {
        board = new int [n][n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        board[row][col] = player;
        for(int x = 0; x < board[0].length; x++){
            if(board[row][x] != player){
                break;
            }
            if((x == board[0].length-1)){
                return player;
            }
        }
        for(int y = 0; y < board[0].length; y++){
            if(board[y][col] != player){
                break;
            }
            if((y == board[0].length-1)){
                return player;
            }
        }
        
        for(int dia = 0; dia < board[0].length; dia++){
            if(board[dia][dia] != player){
                break;
            }
            if((dia == board[0].length-1)){
                return player;
            }
        }
        
        for(int dia = board[0].length-1; dia >= 0; dia--){
            if(board[(board[0].length-1)-dia][dia] != player){
                break;
            }
            if((dia == 0)){
                return player;
            }
        }
        
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */