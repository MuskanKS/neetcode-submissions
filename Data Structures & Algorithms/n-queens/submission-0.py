class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.res = []
        board = [["."] * n for _ in range(n)]

        cols = set()
        downdiag = set()
        updiag = set()

        self.backtrack(0, n, board, cols, downdiag, updiag)
        return self.res

    def backtrack(self, row, n, board, cols, downdiag, updiag):
        if row == n:
            self.res.append(["".join(r) for r in board])
            return 
        
        for col in range(n):
            # agar col ya diagronal pe queen already h 
            if col in cols or (row + col) in downdiag or (row - col) in updiag:
                continue
            
            board[row][col] = "Q"
            cols.add(col)
            downdiag.add(row + col)
            updiag.add(row - col)

            self.backtrack(row + 1, n, board, cols, downdiag, updiag)

            board[row][col] = "."
            cols.remove(col)
            downdiag.remove(row + col)
            updiag.remove(row - col)

