class TicTacToe {
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;

    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diagonal = 0;
        antiDiagonal = 0;
        
    }
    
    public int move(int row, int col, int player) {
        int currPlayer = (player == 1) ? 1: -1;

        rows[row] += currPlayer;
        cols[col] += currPlayer;

        if(row == col) {
            diagonal += currPlayer;
        }

        if(col == cols.length-row-1) {
            antiDiagonal += currPlayer;
        }

        int n = rows.length;
        if(Math.abs(rows[row]) == n || Math.abs(cols[col]) == n
        || Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n) {
            return player;
        }

        return 0;
        
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
