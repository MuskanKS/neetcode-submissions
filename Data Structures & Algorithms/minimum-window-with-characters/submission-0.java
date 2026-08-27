class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hmt = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            hmt.put(ch, hmt.getOrDefault(ch, 0) + 1);
        }

        int low = 0;
        String res = "";
        int minLen = Integer.MAX_VALUE;
        int match = 0;
        HashMap<Character, Integer> hm = new HashMap<>();

        for(int high = 0; high < s.length(); high++){
            char ch = s.charAt(high);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
            if(hmt.containsKey(ch)){
                if(hm.get(ch) <= hmt.get(ch)){
                    match++;
                }
            }
            while(match == t.length()){
                if(minLen > high - low + 1){
                    minLen = high - low + 1;
                    res = s.substring(low, high + 1);
                }
                char leftChar = s.charAt(low);
                if(hmt.containsKey(leftChar) && hm.get(leftChar).equals(hmt.get(leftChar))){
                    match--;
                }
                hm.put(leftChar, hm.get(leftChar) - 1);
                if(hm.get(leftChar) == 0){
                    hm.remove(leftChar);
                }
                low++;
            }

        }
        return res;
    }
}
