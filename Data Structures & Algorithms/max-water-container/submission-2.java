class Solution {
    public int maxArea(int[] heights) {
        // optimise using two pointers
        int max = 0;
        int left = 0;
        int right = heights.length - 1;

        while(left < right){
            // have to find width
            int width = right - left;
            // so when storing water we need to take small height as only that much water will be stored
            int height = Math.min(heights[left], heights[right]);
            int area = width * height;

            max = Math.max(max, area);
            if(heights[left] <= heights[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return max;
    }
}
