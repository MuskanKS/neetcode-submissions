class Solution:
    def evalRPN(self, tokens: List[str]) -> int:

        stack = []
        
        for token in tokens:
            if token not in{'+', '-', '*', '/'}:
                stack.append(int(token))
                continue
            
            right = stack.pop()
            left = stack.pop()

            if token == "+":
                res = left + right
            elif token == "-":
                res = left - right
            elif token == "*":
                res = left * right
            else:
                res = abs(left) // abs(right)
                if (left < 0) != (right < 0):
                    res = -res
            stack.append(res)

        return stack[-1]
            