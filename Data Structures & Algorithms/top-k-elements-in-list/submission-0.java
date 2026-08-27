class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k == nums.length){
            return nums;
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>( (a, b) -> hm.get(a) - hm.get(b));

        for(int n : hm.keySet()){
            heap.add(n);
            if(heap.size() > k){
                heap.remove();
            }
        }

        int[] res = new int[k];
        for(int i = 0; i < k ; i++){
            res[i] = heap.poll();
        }
        return res;
    }
}
