class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.res = []
        self.temp = []
        self.backtrack(s, 0)
        return self.res

    def backtrack(self, s, start):
        if start == len(s):
            self.res.append(self.temp.copy())
            return
        
        for end in range(start, len(s)):
            piece = s[start: end + 1]
            if piece == piece[::-1]:
                self.temp.append(piece)
                self.backtrack(s, end + 1)
                self.temp.pop()
