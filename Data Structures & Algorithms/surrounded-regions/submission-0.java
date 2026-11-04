class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        for(int i = 0; i < row; i++){
            if(board[i][0] == 'O'){
                helper(board, i, 0);
            }
            if(board[i][col - 1] == 'O'){
                helper(board, i, col - 1);
            }
        }
        for(int j = 0; j < col; j++){
            if(board[0][j] == 'O'){
                helper(board, 0, j);
            }
            if(board[row - 1][j] == 'O'){
                helper(board, row - 1, j);
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == 'S'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void helper(char[][] board, int i, int j){
        int row = board.length;
        int col = board[0].length;
        if(i < 0 || j < 0 || i >= row || j >= col || board[i][j] != 'O'){
            return;
        }
        board[i][j] = 'S';
        helper(board, i + 1, j);
        helper(board, i - 1, j);
        helper(board, i, j - 1);
        helper(board, i, j + 1);
    }
}
