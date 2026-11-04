class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 0){
                    q.add(new int[]{i, j});
                }
            }
        }
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};
        int INF = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int[] curr = q.remove();
            int currr = curr[0];
            int currc = curr[1];
            for(int k = 0; k < 4; k++){
                int nr = currr + dr[k];
                int nc = currc + dc[k];
                if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == INF){
                    grid[nr][nc] = grid[currr][currc] + 1;
                    q.add(new int[]{nr, nc});
       
                     }  
            }
            }  
        }
    }
   

