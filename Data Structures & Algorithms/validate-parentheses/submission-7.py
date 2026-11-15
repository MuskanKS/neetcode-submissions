class Solution:
    def isValid(self, s: str) -> bool:
        stack = deque()

        for i in range(len(s)):
            if s[i] == "(" or s[i] == "[" or s[i] == "{":
                stack.append(s[i])
            else:
                if not stack:
                    return False
                elif stack[-1] == "(" and s[i] == ")" or stack[-1] == "[" and s[i] == "]" or stack[-1] == "{" and s[i] == "}":
                    stack.pop()
                else:
                    return False
        return not stack
