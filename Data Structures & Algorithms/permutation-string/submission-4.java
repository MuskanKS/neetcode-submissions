class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // better 
        // we will put frequency 
        int[] arr = new int[26];
        int[] wind = new int[26];

        for(int i = 0; i < s1.length(); i++){
            arr[s1.charAt(i) - 'a']++;
        }
        
        // this portion is repeated.
        // for(int i = 0; i <= s2.length() - s1.length(); i++){
        //     int[] freq = new int[26];
        //     for(int j = i; j < i + s1.length(); j++){
        //         freq[s2.charAt(j) - 'a']++;
        //     }
        // // we will ha
        //     if(Arrays.equals(arr, freq)){
        //         return true;
        //     }
        // }
        // we will have fixed window size of s1.length.
        int low = 0;
        int high = 0;
        while(high < s2.length()){
            wind[s2.charAt(high) - 'a']++;
            // if the size/window size will become too large remove left 
            if(high - low + 1 > s1.length()){
                wind[s2.charAt(low) - 'a']--;
                low++;
            }
            if(Arrays.equals(arr, wind)){
                return true;
            }
            high++;
        }
        return false;
    }
}
