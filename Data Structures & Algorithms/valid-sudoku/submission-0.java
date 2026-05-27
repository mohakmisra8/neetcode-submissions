class Solution {
    public boolean isValidSudoku(char[][] board) {
        // row
        for (int row = 0; row < 9; row++) {
            Set<Character> seen = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[row][j] == '.') {
                    continue;
                }
                if (seen.contains(board[row][j])) {
                    return false;
                }
                seen.add(board[row][j]);
            }
        }
        // col
        for (int col = 0; col < 9; col++) {
            Set<Character> seen = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][col] == '.') {
                    continue;
                }
                if (seen.contains(board[j][col])) {
                    return false;
                }
                seen.add(board[j][col]);
            }
        }

        // 3 x3
        for (int square = 0; square < 9; square++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;

                    if (board[row][col] == '.') {
                        continue;
                    }

                    if (seen.contains(board[row][col])) {
                        return false;
                    }
                    seen.add(board[row][col]);
                }
            }
        }
        return true;
    }
}
