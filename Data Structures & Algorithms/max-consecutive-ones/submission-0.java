class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int res = 0;

        for(int i = 0;i < nums.length;i++) {
            int tempCount = 0;
            for(int j = i; j< nums.length;j++) {
                if(nums[j] == 0) {
                    break;
                }
                tempCount++;
            }
            res = Math.max(tempCount, res);
        }
        return res;
        
    }
}