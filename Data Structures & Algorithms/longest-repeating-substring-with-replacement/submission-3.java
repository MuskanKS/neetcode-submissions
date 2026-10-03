class Solution {
    public int characterReplacement(String s, int k) {
        // optimal 
        int low = 0;
        int high = 0;
        int maxFreq = 0;
        int maxLen = 0;

        int[] freq = new int[26];

        while(high < s.length()){
            freq[s.charAt(high) - 'A']++;
            
            maxFreq = Math.max(maxFreq, freq[s.charAt(high) - 'A']);

            int len = high - low + 1;
            int replace = len - maxFreq;

            while(replace > k){
                freq[s.charAt(low) - 'A']--;
                low++;

                len = high - low + 1;
                replace = len - maxFreq;
            }
            maxLen = Math.max(maxLen, high - low + 1);

            high++;
        }
        return maxLen;
    }
}
