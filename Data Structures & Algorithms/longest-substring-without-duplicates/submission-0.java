class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();

        int left = 0;
        int right = 0;
        int res = 0;

        while(right < s.length()){
            char ch = s.charAt(right);
            while(hs.contains(ch)){
                hs.remove(s.charAt(left));
                left++;
            }
            hs.add(ch);
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
