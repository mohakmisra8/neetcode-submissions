class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int combinedLen = nums1.length + nums2.length;
        int[] merged = new int[combinedLen];
        System.arraycopy(nums1, 0, merged, 0, nums1.length);
        System.arraycopy(nums2, 0, merged, nums1.length, nums2.length);
        Arrays.sort(merged);

        int totalLen = merged.length;
        if(totalLen % 2 == 0) {
            return (merged[totalLen/2 -1] + merged[totalLen/2])/2.0;
        } else{
            return merged[totalLen/2];
        }
    }
}
