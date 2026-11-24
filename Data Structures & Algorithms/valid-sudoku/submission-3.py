class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:

        for i in range(9):
            if not self.helperrow(board,i):
                return False
            if not self.helpercol(board, i):
                return False
        
        for i in range(0, 9, 3):
            for j in range(0, 9, 3):
                if not self.helpergrid(board, i, j):
                    return False
        
        return True
        
    def helperrow(self, board, row):
        hm = set()
        for col in range(9):
            if board[row][col] == ".":
                continue
            if board[row][col] in hm:
                return False
            hm.add(board[row][col])
        return True

    def helpercol(self, board, col):
        hm = set()
        for row in range(9):
            if board[row][col] == ".":
                continue
            if board[row][col] in hm:
                return False
            hm.add(board[row][col])
        return True

    def helpergrid(self, board, srow, scol):
        hm = set()
        for row in range(srow, srow + 3):
            for col in range(scol, scol + 3):
                if board[row][col] == ".":
                    continue
                if board[row][col] in hm:
                    return False
                hm.add(board[row][col])
        return True
