class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int rows = grid.length;
        int cols = grid[0].length;

        int fresh = 0;

        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.add(new int[] {r, c});
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        int minutes = 0;
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                for (int[] d : dirs) {
                    int newR = cell[0] + d[0];
                    int newC = cell[1] + d[1];

                    if(newR >= 0 && newR < rows && newC >= 0 && newC < cols
                    && grid[newR][newC] == 1) {
                        grid[newR][newC] = 2;
                        fresh--;
                        queue.add(new int[]{newR, newC});

                    }
                }
            }
            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}
