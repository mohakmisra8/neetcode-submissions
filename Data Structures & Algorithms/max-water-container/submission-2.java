class Solution {
    public int maxArea(int[] heights) {
        if(heights.length == 0) {
            return 0;
        }

        int left = 0;
        int right = heights.length-1;
        int area = 0;

        while (left < right) {
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);
            int tempA = height*width;
            area = Math.max(tempA, area);

            if(heights[left] < heights[right]) {
                left++;
            } else{
                right--;
            }

        }
        
        return area;
    }
}
