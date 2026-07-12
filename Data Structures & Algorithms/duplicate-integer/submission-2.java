class Solution {
    public boolean hasDuplicate(int[] nums) {
        // iterate through array if count of num in array > 1
        Set<Integer> set = new HashSet<>();
        for(int i:nums) {
            if(set.contains(i)) {
                return true;
            }
            set.add(i);
        }
        return false;
        
    }
}