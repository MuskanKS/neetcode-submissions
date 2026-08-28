class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;

        for(int pile : piles){
            right = Math.max(right, pile);
        }
        while(left < right){
            int mid = left + (right - left) / 2;
            if(canEat(piles, mid, h)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    private static boolean canEat(int[] piles, int speed, int h){
        int hour = 0;
        for(int pile : piles){
            hour += Math.ceil((double) pile / speed);
        }
        return hour <= h;
    }
}
