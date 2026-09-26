class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        // Find nearest smaller on LEFT
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                   heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }

            stack.push(i);
        }

        stack.clear();

        // Find nearest smaller on RIGHT
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() &&
                   heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = stack.peek();
            }

            stack.push(i);
        }

        // Calculate maximum area
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            int width = right[i] - left[i] - 1;

            int area = heights[i] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}