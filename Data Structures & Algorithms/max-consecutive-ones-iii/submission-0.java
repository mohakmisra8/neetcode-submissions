class Solution {
    public int longestOnes(int[] nums, int k) {
        int[] prefix = new int[nums.length+1];

        for(int i =0; i < nums.length;i++) {
            prefix[i+1] = prefix[i] + (nums[i] == 0 ? 1:0);
        }
        int res = 0;
        for(int l = 0; l<nums.length; l++) {
            int low = l;
            int high = nums.length;
            while(low < high) {
                int mid = (low+high)/2;
                if(prefix[mid+1] - prefix[l] <= k) {
                    low = mid+1;
                } else{
                    high = mid;
                }
            }
            res = Math.max(res, low-l);
        }
        return res;

        
    }
}