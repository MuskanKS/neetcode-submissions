class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        backtrack(res, curr, 0, 0, n);

        return res;
    }

    private void backtrack(
        List<String> res,
        StringBuilder curr,
        int open, 
        int close,
        int n
    )
    {
        if(curr.length() == n * 2){
            res.add(curr.toString());
                return;
            }
            if(open < n){
                curr.append('(');
                backtrack(res, curr, open + 1, close, n);

                curr.deleteCharAt(curr.length() - 1);
            }
            if(close < open){
                curr.append(')');
                backtrack(res, curr, open, close + 1, n);

                curr.deleteCharAt(curr.length() - 1);
            }
        

    }
}
