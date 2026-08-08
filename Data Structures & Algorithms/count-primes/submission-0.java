class Solution {
    public int countPrimes(int n) {
        if (n < 2){
            return 0;
        }

        boolean[] composite = new boolean[n];
        int count = 0;

        for(int num = 2; num< n; num++) {
            if(!composite[num]) {
                count++;

                for(int multiple = num+num; multiple < n; multiple+= num) {
                    composite[multiple] = true;
                }
            }
        }
        return count;
    }
}