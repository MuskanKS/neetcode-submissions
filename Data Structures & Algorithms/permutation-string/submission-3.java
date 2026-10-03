class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // better 
        // we will put frequency 
        int[] arr = new int[26];

        for(int i = 0; i < s1.length(); i++){
            arr[s1.charAt(i) - 'a']++;
        }

        for(int i = 0; i <= s2.length() - s1.length(); i++){
            int[] freq = new int[26];
            for(int j = i; j < i + s1.length(); j++){
                freq[s2.charAt(j) - 'a']++;
            }
            if(Arrays.equals(arr, freq)){
                return true;
            }
        }
        return false;
    }
}
