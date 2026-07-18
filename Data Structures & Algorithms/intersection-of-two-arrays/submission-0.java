class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int a: nums1){
            set1.add(a);
        }

        for(int b:nums2) {
            set2.add(b);
        }

        return set1.stream().filter(set2::contains)
        .mapToInt(Integer::intValue)
        .toArray();

    }
}