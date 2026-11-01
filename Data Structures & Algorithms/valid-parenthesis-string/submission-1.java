
class Solution {

    private Boolean[][] memo;

    public boolean checkValidString(String s) {

        int n = s.length();
        memo = new Boolean[n][n + 1];

        return dfs(s, 0, 0);
    }

    private boolean dfs(String s, int index, int balance) {

        // Invalid: too many closing parentheses
        if (balance < 0) {
            return false;
        }

        // Reached the end
        if (index == s.length()) {
            return balance == 0;
        }

        // Already solved this state
        if (memo[index][balance] != null) {
            return memo[index][balance];
        }

        char ch = s.charAt(index);

        boolean result;

        if (ch == '(') {
            result = dfs(s, index + 1, balance + 1);
        } else if (ch == ')') {
            result = dfs(s, index + 1, balance - 1);
        } else {
            result = dfs(s, index + 1, balance + 1) ||
                     dfs(s, index + 1, balance - 1) ||
                     dfs(s, index + 1, balance);
        }

        memo[index][balance] = result;
        return result;
    }
}
