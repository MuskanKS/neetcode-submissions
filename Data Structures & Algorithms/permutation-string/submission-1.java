class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        int low = 0;
        
        for(int i = 0; i < s1.length(); i++){
            cnt1[s1.charAt(i) - 'a']++;
        }

        for(int high = 0; high < s2.length(); high++){
             cnt2[s2.charAt(high) - 'a']++;

            if(high - low + 1 == s1.length()){
                if(Arrays.equals(cnt1, cnt2)){
                    return true;
            }
            cnt2[s2.charAt(low) - 'a']--;
            low++;
            }
        }
        return false;
    }
}
