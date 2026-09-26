class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        Deque<Integer> dq  = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            while(!dq.isEmpty() && temperatures[i] > temperatures[dq.peek()]){
                int prev = dq.pop();
                res[prev] = i - prev;
            }
            dq.push(i);
        }
        return res;
    }
}
