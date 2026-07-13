class Solution {
    public int trap(int[] height) {
        if(height.length == 0) {
            return 0;
        }
        int area = 0;
        int left = 0;
        int right = height.length-1;
        int rightMax = height[right];
        int leftMax = height[left];

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                area += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                area += rightMax - height[right];
            }
        }
        return area;
        
    }
}
