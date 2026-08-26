class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<int[]> set = new HashSet<>();
        for(int i = 0; i< nums.length;i++) {
            for(int j =i+1; j<nums.length;j++) {
                if(nums[i]-nums[j] == 0 && Math.abs(i-j) <=k) {
                    return set.add(new int[]{i,j});
                }
            }
        }
        return false;
        
    }
}