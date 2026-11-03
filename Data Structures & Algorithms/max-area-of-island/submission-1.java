class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        // bfs
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
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        vis[r][c] = true;
        int area = 1;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};

        while(!q.isEmpty()){
            int[] elem = q.remove();
            int er = elem[0];
            int ec = elem[1];
            for(int k = 0; k < 4; k++){
                int nr = er + dr[k];
                int nc = ec + dc[k];
                if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1 && !vis[nr][nc]){
                    vis[nr][nc] = true;
                    area++;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return area;
    }
}
