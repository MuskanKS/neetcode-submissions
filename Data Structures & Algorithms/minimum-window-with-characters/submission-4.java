class Solution {
    public String minWindow(String s, String t) {
        // BRUTE
        String ans = "";
        int[] need = new int[128];

        for(int i = 0; i < t.length(); i++){
            need[t.charAt(i)]++;
        }
        int require = 0;

        for(int i = 0; i < 128; i++){
            if(need[i] > 0){
                require++;
            }
        }

        int have = 0;

        int low = 0;
        int high = 0;

        int minLen = Integer.MAX_VALUE;
        int minLow = 0;
        int[] wind = new int[128];

        while(high < s.length()){
            char ch = s.charAt(high);
            wind[ch]++;

            if(need[ch] > 0 && wind[ch] == need[ch]){
                have++;
            }
            while(have == require){
                if(high - low + 1 < minLen){
                    minLen = high - low + 1;
                    minLow = low;
                }
                char remove = s.charAt(low);
                wind[remove]--;

                if(need[remove] > 0 && wind[remove] < need[remove]){
                    have--;
                }
                low++;
            }
            high++;
        }
        if(minLen == Integer.MAX_VALUE){
            return "";
        
        }
        return s.substring(minLow, minLow + minLen);
    }
}
