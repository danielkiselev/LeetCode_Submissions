class Solution {

    public int[][] candyCrush(int[][] board) {
        int m = board.length;// y
        int proc = -1;
        int n = board[0].length;// x
        while (proc != 0) {
            int[][] tags = new int[m][n];// y,x
            for (int x = 0; x < n; x++) {
                for (int y = 1; y < (m - 1); y++) {
                    int curr = board[y][x];
                    if (curr == 0) {
                        continue;
                    }
                    int prev = board[y - 1][x];
                    int next = board[y + 1][x];
                    if (prev == curr && next == curr) {
                        tags[y][x] = 1;
                        tags[y - 1][x] = 1;
                        tags[y + 1][x] = 1;
                        proc = 1;
                    }
                }
            }
            for (int y = 0; y < m; y++) {
                for (int x = 1; x < (n - 1); x++) {
                    int curr = board[y][x];
                    if (curr == 0) {
                        continue;
                    }
                    int prev = board[y][x - 1];
                    int next = board[y][x + 1];
                    if (prev == curr && next == curr) {
                        tags[y][x] = 1;
                        tags[y][x - 1] = 1;
                        tags[y][x + 1] = 1;
                        proc = 1;
                    }
                }
            }
            if (proc != 1) {
                return board;
            }
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    if (tags[y][x] == 1) {
                        board[y][x] = 0;
                    }
                }
            }
            int[][] res = board.clone();
            proc = 0;
            for (int x = 0; x < n; x++) {
                int index = 0;
                for (int y = m - 1; y >= 0; y--) {
                    if (board[y][x] == 0) {
                        index++;
                    } else {
                        if (index != 0) {
                            proc = -1;
                            res[y + index][x] = board[y][x];
                        }
                    }
                }
                if (proc == -1) {

                    for (int y = 0; y < index; y++) {

                        res[y][x] = 0;
                    }
                    board = res;
                }
            }

        }
        return board;
    }

}