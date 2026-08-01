class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] output = new int[len-k+1];

        for(int i = 0; i <= len-k; i++) {
            int maxI = nums[i];
            for(int j = i; j< i +k; j++) {
                maxI = Math.max(maxI, nums[j]);
            }
            output[i] = maxI;
        }

        return output;
        
    }
}
