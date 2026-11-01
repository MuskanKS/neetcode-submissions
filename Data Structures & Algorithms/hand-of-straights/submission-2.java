class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }

        HashMap<Integer, Integer> count = new HashMap<>();

        for(int num : hand){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        List<Integer> res = new ArrayList<>(count.keySet());
        Collections.sort(res);

        for(int start : res){
            int freq = count.get(start);
            if(freq == 0){
                continue;
            }
            for(int offset = 0; offset < groupSize; offset++){
                int target = start + offset;
                int avail = count.getOrDefault(target, 0);
                if(avail < freq){
                    return false;
                }
                count.put(target, avail - freq);
            }
        }
        return true;
    }
}
