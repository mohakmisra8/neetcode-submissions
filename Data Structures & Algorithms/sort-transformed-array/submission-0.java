class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        for(int i =0; i< nums.length;i++) {
            int x = nums[i];
            int y = (a*nums[i]*nums[i])+(b*nums[i]) +c;
            nums[i] = y;
        }
        Arrays.sort(nums);
        return nums;
        
    }
}
