class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // optimal
        int left = 1;
        int right = 0;
        for(int i = 0; i < piles.length; i++){
            right = Math.max(right, piles[i]);
        }
        

        while(left <= right){
            int k = left + (right - left) / 2;    //k is mid just assuming k is koko eating itna like that
            long hours = 0;

            for(int pile : piles){
                hours += (pile + k - 1)/k;
            }
            if(hours <= h){
                // if k works try smaller speed ofn koko
                right = k - 1; 
            }else {
                left = k + 1;
            }

        }
        return left;
    }
}