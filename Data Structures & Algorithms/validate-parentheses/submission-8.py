class Solution:
    def isValid(self, s: str) -> bool:
        dq = deque()

        for i in range(len(s)):
            if s[i] == "[" or s[i] == "{" or s[i] == "(":
                dq.append(s[i])
            else:
                if not dq:
                    return False
                else:
                    if s[i] == ")" and dq[-1] == "(" or s[i] == "}" and dq[-1] == "{" or s[i] == "]" and dq[-1] == "[":
                        dq.pop()
                    else: 
                        return False

        return not dq