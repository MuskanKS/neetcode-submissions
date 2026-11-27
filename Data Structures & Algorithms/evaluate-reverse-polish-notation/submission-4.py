class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        s = []

        for token in tokens:
            if token not in {'+', '-', '*', '/'}:
                s.append(int (token))
                continue
            right = s.pop()
            left = s.pop()

            if token == "+":
                res = left + right
            elif token == "-":
                res = left - right
            elif token == "*":
                res = left * right

            else:
                # we divide when curr token is "/"
                res = abs(left) // abs(right)
                if (left < 0) != (right < 0 ):
                    res = -res

            s.append(res)

        return s[-1]
        
            