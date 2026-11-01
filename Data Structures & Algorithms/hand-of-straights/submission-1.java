class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // better
        if(hand.length % groupSize != 0){
            return false;
        }

        Arrays.sort(hand);
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num : hand){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        for(int num : hand){
            if(hm.get(num) == 0){
                continue;
            }
            for(int j = 0; j < groupSize; j++){
                int target = num + j;
                if(hm.getOrDefault(target, 0) == 0){
                    return false;
                }
                hm.put(target, hm.get(target) - 1);
            }
        }
        return true;
    }
}
