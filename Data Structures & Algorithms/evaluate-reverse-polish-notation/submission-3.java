class Solution {
    public int evalRPN(String[] tokens) {

        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {

            if (token.equals("+") ||
                token.equals("-") ||
                token.equals("*") ||
                token.equals("/")) {

                int right = stack.pop();
                int left = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(left + right);
                        break;

                    case "-":
                        stack.push(left - right);
                        break;

                    case "*":
                        stack.push(left * right);
                        break;

                    case "/":
                        stack.push(left / right);
                        break;
                }

            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}