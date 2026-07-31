class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        nums = Arrays.stream(nums).distinct().toArray();
        int count = 1;
        int tempcount = 1;
        for(int i = 0;i < nums.length-1;i++) {
            if(nums[i+1]- nums[i] == 1) {
                tempcount++;
                count = Math.max(count, tempcount);
            } else{
                tempcount = 1;
            }
        }
        return count;
        
    }
}
