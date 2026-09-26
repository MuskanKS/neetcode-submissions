class Solution {
    public boolean isValid(String s) {
        // lets optimise it and do using deque
        Deque<Character> dq = new ArrayDeque<>();

        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                dq.push(ch);
            }else{
                if(dq.isEmpty()){
                    return false;
                }
                char top = dq.pop();
                if((ch == ')' && top != '(' || ch == '}' && top != '{' || ch == ']' && top != '[')){
                    return false;
                }
            }
        }
        return dq.isEmpty();
    }
}
