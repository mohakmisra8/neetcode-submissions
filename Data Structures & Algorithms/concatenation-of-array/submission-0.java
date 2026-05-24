class Solution {
    public int[] getConcatenation(int[] nums) {
        final var newArr = new int[2*nums.length];
        for (int i = 0;i <nums.length;i++) {
            newArr[i] = nums[i];
            newArr[i+nums.length] = nums[i];
        }
        return newArr;
        
    }
}