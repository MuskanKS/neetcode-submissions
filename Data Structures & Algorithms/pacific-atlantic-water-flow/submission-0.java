class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;

        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        for(int r = 0; r < row; r++){
            helper(heights, r, 0, pacific);
            helper(heights, r, col - 1, atlantic);
        }

        for(int c = 0; c < col; c++){
            helper(heights, 0, c, pacific);
            helper(heights, row - 1, c, atlantic);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
    private void helper(int[][] heights, int r, int c, boolean[][] vis){
        vis[r][c] = true;
        int[][] direc = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

        for(int[] dir: direc){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr < 0 || nc < 0 || nr >= heights.length || nc >= heights[0].length){
                continue;
            }
            if(vis[nr][nc]){
                continue;
            }
            if(heights[nr][nc] < heights[r][c]){
                continue;
            }
            helper(heights, nr, nc, vis); 
        }

    }
}
