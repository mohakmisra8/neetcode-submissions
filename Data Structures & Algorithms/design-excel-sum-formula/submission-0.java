class Excel {
    private int[][] values;
    private Map<String, List<String>> formulas;

    public Excel(int height, char width) {
        int cols = width - 'A' + 1;
        values = new int[height + 1][cols];
        formulas = new HashMap<>();
    }

    public void set(int row, char column, int val) {
        String key = row + "" + column;
        formulas.remove(key);
        values[row][column - 'A'] = val;
    }

    public int get(int row, char column) {
        String key = row + "" + column;
        if(formulas.containsKey(key)) {
            int sum = 0;
            for(String cell: formulas.get(key)) {
                if(cell.contains(":")) {
                    String[] ends = cell.split(":");
                    int r1 = rowOf(ends[0]);
                    int r2  = rowOf(ends[1]);
                    char c1 = colOf(ends[0]);
                    char c2 = colOf(ends[1]);
                    for(int r = r1; r<= r2;r++) {
                        for(char c=c1;c <= c2;c++) {
                            sum += get(r,c); // dfs recurse
                        }
                    }
                } else{
                    sum+= get(rowOf(cell), colOf(cell));
                }
            }
            return sum;

        }
        return values[row][column - 'A'];
    }

    public int sum(int row, char column, String[] numbers) {
        String key = row + "" + column;
        formulas.put(key, Arrays.asList(numbers));
        return get(row, column);
    }

    private int rowOf(String cell) {
        return Integer.parseInt(cell.substring(1));
    }

    private char colOf(String cell) { return cell.charAt(0); }

}

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(height, width);
 * obj.set(row,column,val);
 * int param_2 = obj.get(row,column);
 * int param_3 = obj.sum(row,column,numbers);
 */
