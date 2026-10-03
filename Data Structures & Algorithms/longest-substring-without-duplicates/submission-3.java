class Solution {
    public int lengthOfLongestSubstring(String s) {
        // better
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            HashSet<Character> hs = new HashSet<>();
            for(int j = i; j < s.length(); j++){
                if(hs.contains(s.charAt(j))){
                    break;
                }
                hs.add(s.charAt(j));
                max = Math.max(max, j - i + 1);
                
            }
        }
        return max;
    }
}
