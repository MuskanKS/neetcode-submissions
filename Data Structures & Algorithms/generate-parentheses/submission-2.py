class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        self.res = []
        self.temp = []
        self.backtrack(n, 0, 0)
        return self.res

    def backtrack(self, n, openCount, closeCount):
        if len(self.temp) == 2 * n:
            self.res.append("".join(self.temp))
            return
        
        if openCount < n:
            self.temp.append("(")
            self.backtrack(n, openCount + 1, closeCount)
            self.temp.pop()

        if closeCount < openCount:
            self.temp.append(")")
            self.backtrack(n, openCount, closeCount + 1)
            self.temp.pop()
