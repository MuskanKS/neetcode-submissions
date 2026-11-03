class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        // dfs
        int max = 0;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] vis = new boolean[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    int area = helper(grid, i, j , vis);
                    max = Math.max(max, area);
                }
                continue;
            }
        }
        return max;
    }
    private int helper(int[][] grid, int r, int c, boolean[][] vis){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
            return 0;
        }
        
        if(grid[r][c] == 0 || vis[r][c]){
            return 0;
        }
        
        vis[r][c] = true;
        int area = 1;
        area += helper(grid, r - 1, c, vis);
        area += helper(grid, r + 1, c, vis);
        area += helper(grid, r, c - 1, vis);
        area += helper(grid, r, c + 1, vis);

        return area;
    }
}
