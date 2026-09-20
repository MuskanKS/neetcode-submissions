

class Solution {
    public boolean isValidSudoku(char[][] board) {

        // Check every row and column
        for (int i = 0; i < 9; i++) {
            if (!helperRow(board, i) || !helperCol(board, i)) {
                return false;
            }
        }

        // Check each 3x3 grid
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!helperGrid(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean helperRow(char[][] board, int row) {
        HashSet<Character> hs = new HashSet<>();

        for (int j = 0; j < 9; j++) {
            char ch = board[row][j];

            if (ch == '.') {
                continue;
            }

            if (hs.contains(ch)) {
                return false;
            }

            hs.add(ch);
        }

        return true;
    }

    private boolean helperCol(char[][] board, int col) {
        HashSet<Character> hs = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            char ch = board[i][col];

            if (ch == '.') {
                continue;
            }

            if (hs.contains(ch)) {
                return false;
            }

            hs.add(ch);
        }

        return true;
    }

    private boolean helperGrid(char[][] board, int row, int col) {
        HashSet<Character> hs = new HashSet<>();

        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                char ch = board[i][j];

                if (ch == '.') {
                    continue;
                }

                if (hs.contains(ch)) {
                    return false;
                }

                hs.add(ch);
            }
        }

        return true;
    }
}