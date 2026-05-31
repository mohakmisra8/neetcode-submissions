class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // set pointer a b c
        // if a + b+ c == 0 add to list
        // for int a
        //      for int b
        //          for int c
                        // nums[a] + nums[b] + nums[c] == 0
                        // add

        Set<List<Integer>> res = new HashSet<>();

        for(int a = 0; a< nums.length;a++) {
            for(int b = a+1;b<nums.length;b++) {
                for(int c = b+1; c <nums.length;c++) {
                    if(nums[a]+nums[b]+nums[c] == 0) {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[a]);
                        triplet.add(nums[b]);
                        triplet.add(nums[c]);
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                }
            }
        }
        return new ArrayList<>(res);
        
    }
}
