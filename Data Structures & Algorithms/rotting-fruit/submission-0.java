class Solution {
    public int orangesRotting(int[][] grid) {
        // we can solvce this using bfs
        Queue<int[]> q = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        int min = 0;
        int fresh = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};

        while(!q.isEmpty() && fresh > 0){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curr = q.remove();
                int r = curr[0];
                int c = curr[1];
                for(int k = 0; k < 4; k++){
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        fresh--;
                        q.add(new int[]{nr, nc});
                    }
                }
            
            }
            
            min++;
        }
        return fresh == 0 ? min : -1;
    }
}
