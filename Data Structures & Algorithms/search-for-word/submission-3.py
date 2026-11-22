class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        row = len(board)
        col = len(board[0])

        for i in range(row):
            for j in range(col):
                if self.dfs(board, word, i, j, 0, set()):
                    return True
        
        return False
    
    def dfs(self, board, word, r, c, idx, vis):
        if r < 0 or r >= len(board) or c < 0 or c >= len(board[0]) or (r, c) in vis or  board[r][c] != word[idx]:
            return False
        
        if idx == len(word) - 1:
            return True
        
        vis.add((r, c))

        find = self.dfs(board, word, r + 1, c, idx + 1, vis) or self.dfs(board, word, r, c + 1, idx + 1, vis) or self.dfs(board, word, r - 1, c, idx + 1, vis) or self.dfs(board, word, r, c - 1, idx + 1, vis)

        vis.remove((r, c))
        return find

