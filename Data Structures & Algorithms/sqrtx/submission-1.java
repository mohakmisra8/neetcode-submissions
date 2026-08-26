class Solution {
    public int mySqrt(int x) {
        if(x == 0) {
            return 0;
        }
        int res = 0;
        for(int i = 0; i<= x;i++) {
            if((long) i*i>x) {
                return res;
            }
            res = i;
        }

        return res;


        
    }
}