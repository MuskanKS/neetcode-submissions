class Solution {
    public int characterReplacement(String s, int k) {
       int low = 0;
       int maxFreq = 0;
       int maxLen = 0;
       HashMap<Character, Integer> hm = new HashMap<>();

       for(int high = 0; high < s.length(); high++){
        char ch = s.charAt(high);
        hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        maxFreq = Math.max(maxFreq, hm.get(ch));
        while((high - low + 1) - maxFreq > k){
            char leftChar = s.charAt(low);
            hm.put(leftChar, hm.get(leftChar) - 1);
            if(hm.get(leftChar) == 0){
                hm.remove(leftChar);
            }
            low++;
        }
        maxLen = Math.max(maxLen, high - low + 1);
       } 
       return maxLen;
    }
}
