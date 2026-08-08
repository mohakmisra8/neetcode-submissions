class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findFirst(nums, target), findLast(nums, target)};
    }

    private int findFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                result = mid;
                high = mid - 1; // keep looking left for earliest occurence
            } else if (nums[mid] < target) {
                low = mid + 1; // target is to the right
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private int findLast(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                result = mid;
                low = mid + 1; // epe looking right
            } else if (nums[mid] < target) {
                low = mid + 1; // target is to the right
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}