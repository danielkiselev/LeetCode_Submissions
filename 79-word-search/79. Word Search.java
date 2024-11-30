class Solution {
    public boolean exist(char[][] board, String word) {
        int [][] visited = new int [board.length][board[0].length];
        for(int y = 0; y<board.length; y++){
            for(int x = 0; x<board[0].length; x++){
                char letter = board[y][x];
                if(word.charAt(0) == letter){
                    visited[y][x] = 1;
                    if(trav(y, x, board, word, 1, visited)){
                        return true;
                    }
                    visited[y][x] = 0;
                }
            }
        }
        return false;
    }
    
    private boolean trav(int y, int x, char[][] board, String word, int index, int[][] visited ){
        if(word.length() == index){
            return true;
        }
        if(x!=0){
            if(visited[y][x-1] == 0){
                if(board[y][x-1] == word.charAt(index)){
                    visited[y][x-1] = 1;
                    if(trav(y, x-1, board, word, index+1, visited)){
                        return true;
                    }
                    visited[y][x-1] = 0;
                }
            }
        }
        if(x!=board[0].length-1){
            if(visited[y][x+1] == 0){
                if(board[y][x+1] == word.charAt(index)){
                    visited[y][x+1] = 1;
                    if(trav(y, x+1, board, word, index+1,visited )){
                        return true;
                    }
                    visited[y][x+1] = 0;
                }
            }
        }
        if(y!=0){
            if(visited[y-1][x] == 0){
                if(board[y-1][x] == word.charAt(index)){
                    visited[y-1][x] = 1;
                    if(trav(y-1, x, board, word, index+1, visited)){
                        return true;
                    }
                    visited[y-1][x] = 0;
                }
            }
        }
        if(y!=board.length-1){
            if(visited[y+1][x] == 0){
                if(board[y+1][x] == word.charAt(index)){
                    visited[y+1][x] = 1;
                    if(trav(y+1, x, board, word, index+1,visited )){
                        return true;
                    }
                    visited[y+1][x] = 0;
                }
            }
        }
        return false;
    }
}