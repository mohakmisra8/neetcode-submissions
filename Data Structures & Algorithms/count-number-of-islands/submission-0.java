class Solution {

        private static final int[][] directions = {{1, 0}, {-1, 0},
                                               {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int col) {
        if (r < 0 || col < 0 || r >= grid.length || col >= grid[0].length || grid[r][col] == '0') {
            return;
        }

        grid[r][col] = '0';
        for(int[] dir:directions) {
            dfs(grid,r +dir[0], col +dir[1]);
        }
    }
}
