class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int area = 0;
        int right = heights.length - 1;

        while (left < right) {
            // area = width* height
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);
            int tempA = width * height;
            area = Math.max(tempA, area);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }
}
