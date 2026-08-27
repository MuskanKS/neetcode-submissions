class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] row = new HashSet[9];
        HashSet<Character>[] col = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for(int r = 0; r < 9; r++){
            row[r] = new HashSet<>();
            col[r] = new HashSet<>();
            boxes[r] = new HashSet<>();

        }

        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                char val = board[r][c];
                if(val == '.'){
                    continue;
                }
                if(row[r].contains(val)){
                    return false;
                }
                row[r].add(val);

                if(col[c].contains(val)){
                    return false;
                } 
                col[c].add(val);

                int idx = (r / 3) * 3 + (c / 3);

                if(boxes[idx].contains(val)){
                    return false;
                }
                boxes[idx].add(val);
            }
        }
        return true;

    }
}
