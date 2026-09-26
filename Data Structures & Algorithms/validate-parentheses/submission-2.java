class Solution {
    public boolean isValid(String s) {
        // better
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            // if open bracket than add in the stack
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }else{
                // if stack empty then false
                if(stack.isEmpty()){
                    return false;
                }
                // if closing bracket and same then pop
                char top = stack.pop();
                if((top == '(' &&  ch != ')' || top == '[' && ch != ']' || top == '{' && ch != '}')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
