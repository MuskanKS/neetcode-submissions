class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char task : tasks){
            freq[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for(int count : freq){
            if(count > 0){
                maxHeap.add(count);
            }
        }
        int cycles = 0;
        while(!maxHeap.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int time = 0;

            while(time <= n){
                if(!maxHeap.isEmpty()){
                    int count = maxHeap.remove();
                    if(count > 1){
                        temp.add(count - 1);
                    }
                }
                cycles++;
                time++;

                if(maxHeap.isEmpty() && temp.isEmpty()){
                    break;
                }
            }
            for(int count : temp){
                maxHeap.offer(count);
            }
        }
        return cycles;
    }
}
