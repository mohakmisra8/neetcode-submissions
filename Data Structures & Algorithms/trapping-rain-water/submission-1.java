class Solution {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length-1;
        int leftMax = height[left];
        int rightMax = height[right];
        int area = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(height[left], leftMax);
                area += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(height[right], rightMax);
                area += rightMax - height[right];
            }
        }
        return area;
    }
}
