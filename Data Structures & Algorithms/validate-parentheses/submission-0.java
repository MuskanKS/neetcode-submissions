class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> hm = new HashMap<>();
        hm.put(')', '(');
        hm.put(']', '[');
        hm.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!hm.containsKey(ch)){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char topEle = stack.pop();
                if(topEle != hm.get(ch)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
