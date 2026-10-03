class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] max = new int[nums.length - k + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for(int i = 0; i < k; i++){
            pq.offer(new int[]{nums[i], i});
        }
        max[0] = pq.peek()[0];
        int idx = 1;

        for(int high = k; high < nums.length ; high++){
            pq.offer(new int[]{nums[high], high});
            while(pq.peek()[1] <= high - k){
                pq.remove();
            }
            max[idx] = pq.peek()[0];
            idx++;
           
        }
        return max;
    }
}
