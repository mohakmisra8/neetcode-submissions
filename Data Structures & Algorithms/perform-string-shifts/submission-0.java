class Solution {
    public String stringShift(String s, int[][] shift) {
        int len = s.length();

        for(int[] move: shift) {
            int direction = move[0];
            int amount = move[1] % len;

            if(direction == 0) {
                s = s.substring(amount) + s.substring(0, amount);
            } else {
                s = s.substring(len-amount)+s.substring(0, len-amount);
            }

        }
        return s;
        
    }
}
