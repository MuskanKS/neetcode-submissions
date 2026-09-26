class Solution {
    public boolean isValid(String s) {
        // brute
        // keep removing adjucing pairs until no pair is left
        while(s.contains("()") || s.contains("[]") || s.contains("{}")){
            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");
        }
        return s.length() == 0;
    }
}
