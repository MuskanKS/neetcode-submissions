class Solution {
    public int lengthOfLongestSubstring(String s) {
        // optimal
        int max = 0;
        int low = 0;
        int high = 0;
        HashSet<Character> hs = new HashSet<>();

        while(high < s.length()){
            while(hs.contains(s.charAt(high))){
                hs.remove(s.charAt(low));
                low++;
            }
            hs.add(s.charAt(high));
            max = Math.max(max, high - low + 1);
            high++;
        }
        return max;

    }
}
