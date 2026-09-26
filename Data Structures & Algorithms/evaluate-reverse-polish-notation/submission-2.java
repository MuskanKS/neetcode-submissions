class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(String token : tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int right = s.pop();
                int left = s.pop();

                int res = 0;
                if(token.equals("+")){
                    res = left + right;
                }else if(token.equals("-")){
                    res = left - right;
                }else if(token.equals("/")){
                    res = left / right;
                }else{
                    res = left * right;
                }

                s.push(res);
            }else{
                s.push(Integer.parseInt(token));
            }
        }
        return s.pop();
    }
}
