class Solution {
    public int numIslands(char[][] grid) {
        // bfs
        int row = grid.length;
        int col = grid[0].length;
        int island = 0;
        boolean[][] vis = new boolean[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    island++;
                    helper(grid, i, j, vis);
                }
                continue;
            }
        }
        return island;
    }
    private void helper(char[][] grid, int r, int c, boolean[][] vis){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        vis[r][c] = true;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};

        while(!q.isEmpty()){
            int[] elem = q.remove();
            int er = elem[0];
            int ec = elem[1];
            for(int k = 0; k < 4; k++){
                int nr = er + dr[k];
                int nc = ec + dc[k];
                if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1' && !vis[nr][nc]){
                    vis[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }

    }
}
