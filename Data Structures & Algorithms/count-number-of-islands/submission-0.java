class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int cols = grid[0].length;

        boolean[][] vis = new boolean[row][cols];
        int island = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    island++;
                    helper(grid, vis, i, j);
                }
                continue;
            }
        }
        return island;
    }
    private void helper(char[][] grid, boolean[][] vis, int r, int c){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
            return;
        }
        if(grid[r][c] == '0' || vis[r][c]){
            return;
        }
        vis[r][c] = true;
        helper(grid, vis, r - 1, c); //up
        helper(grid, vis, r + 1, c); //down
        helper(grid, vis, r, c - 1); //left
        helper(grid, vis, r, c + 1); //right
    }
}
