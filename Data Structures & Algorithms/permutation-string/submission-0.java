class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> hm = new HashMap<>();
        HashMap<Character, Integer> hm1 = new HashMap<>();
        int low = 0;
        
        for(int i = 0; i < s1.length(); i++){
            char ch = s1.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        for(int high = 0; high < s2.length(); high++){
            char ch = s2.charAt(high);
            hm1.put(ch, hm1.getOrDefault(ch, 0) + 1);

            if(high - low + 1 == s1.length()){
                if(hm.equals(hm1)){
                    return true;
                }
                char leftChar = s2.charAt(low);
                hm1.put(leftChar, hm1.get(leftChar) - 1);
                if(hm1.get(leftChar) == 0){
                    hm1.remove(leftChar);
                }
                low++;
            }
        }
        return false;
    }
}
