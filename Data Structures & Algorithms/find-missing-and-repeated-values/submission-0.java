class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = grid.length;

        for(int i =0; i<n;i++) {
            for(int j =0; j<n;j++) {
                map.put(grid[i][j],
                map.getOrDefault(grid[i][j], 0)+1);
            }
        }
        int doubleVal = 0;
        int missing = 0;

        for(int num =1; num <= n*n;num++) {
            int freq = map.getOrDefault(num, 0);
            if(freq == 0) {
                missing = num;
            }

            if(freq == 2){
                doubleVal = num;
            }
        }

        return new int[]{doubleVal, missing};
        
    }
}