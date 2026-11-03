class Solution {
    public int numIslands(char[][] grid) {
        int island = 0;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] vis = new boolean[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    island++;
                    helper(grid, i, j, vis);
                }continue;
            }
        }
        return island;
    }
    private void helper(char[][] grid, int r, int c, boolean[][] vis){
        if(r >= grid.length || r < 0 || c >= grid[0].length || c < 0){
            return;
        }

        if(grid[r][c] == '0' || vis[r][c]){
            return;
        }

        vis[r][c] = true;

        helper(grid, r - 1, c, vis); //up
        helper(grid, r + 1, c, vis); //down
        helper(grid, r, c - 1, vis); //left
        helper(grid, r, c + 1, vis); //right;

    }
}
