

class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Store query values with their original indices
        int[][] sortedQueries = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        // Heap stores {interval length, interval right endpoint}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[] result = new int[queries.length];
        int i = 0;

        for (int[] query : sortedQueries) {
            int q = query[0];
            int index = query[1];

            // Add intervals whose start <= query
            while (i < intervals.length && intervals[i][0] <= q) {
                int left = intervals[i][0];
                int right = intervals[i][1];
                int length = right - left + 1;

                minHeap.offer(new int[]{length, right});
                i++;
            }

            // Remove intervals that cannot contain this query
            while (!minHeap.isEmpty() && minHeap.peek()[1] < q) {
                minHeap.poll();
            }

            // The shortest valid interval is at the top
            result[index] = minHeap.isEmpty() ? -1 : minHeap.peek()[0];
        }

        return result;
    }
}