class KthLargest {
    private List<Integer> nums;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = new ArrayList<>();
        for(int num : nums){
            this.nums.add(num);
        }
    }
    
    public int add(int val) {
        nums.add(val);

        Collections.sort(nums, Collections.reverseOrder());

        return nums.get(k - 1);
    }
}
