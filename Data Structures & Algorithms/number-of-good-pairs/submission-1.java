class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] freq = new int[101];
        int count = 0;
        for(int n: nums) {
            count += freq[n];
            freq[n]++;
        }
        return count;
        
    }
}