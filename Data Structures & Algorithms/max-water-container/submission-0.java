class Solution {
    public int maxArea(int[] heights) {
        // use two pointers to go from left to right
        // if left < right keep right but increase left
        // if left > right choose min of heights[left] and heights[right]
        // area = product of difference in (right-left)*min(heights[left], heights[right])
        int area = 0;
        int left = 0;
        int right = heights.length-1;

        while(left < right) {
                int width = right-left;
                int height = Math.min(heights[left], heights[right]);
                int newArea = height*width;
                area = Math.max(area, newArea);

                if(heights[left] < heights[right]) {
                    left++;
                } else{
                    right--;
                }
        }

        return area;
        
    }
}
