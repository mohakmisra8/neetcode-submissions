class Solution {
    public int countPrimes(int n) {
        if (n < 2){
            return 0;
        }

        boolean[] composite = new boolean[n];
        int count = 0;

// go through every number from 2 updwards. for each number it asks had it been crossed out already
// if strill standing it must be a prime
        for(int num = 2; num< n; num++) {
            if(!composite[num]) {
                count++;

// once confirmed it is a prime then you eliminate all its multiple as they are guaranteed to not be prime
// num + num = 2*num first multuple of num bigger than num itself
// multiple += num = each iteration jumps forward by num landing on multiples
// multiple less than -> until n
                for(int multiple = num+num; multiple < n; multiple+= num) {
                    composite[multiple] = true;
                }
            }
        }
        return count;
    }
}