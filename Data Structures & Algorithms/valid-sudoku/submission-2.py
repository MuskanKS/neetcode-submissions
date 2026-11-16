class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for i in range(9):
            if not self.helperRow(board, i) or not self.helperCol(board, i):
                return False

        for row in range(0, 9, 3):
            for col in range(0, 9, 3):
                if not self.helperGrid(board, row, col):
                    return False

        return True

    def helperRow(self, board, row):
        hm = set()
        for col in range(9):
            ch = board[row][col]
            if ch == '.':
                continue
            if ch in hm:
                return False
            hm.add(ch)
        return True

    def helperCol(self, board, col):
        hm = set()
        for row in range(9):
            ch = board[row][col]
            if ch == '.':
                continue
            if ch in hm:
                return False
            hm.add(ch)
        return True

    def helperGrid(self, board, row, col):
        hm = set()
        for i in range(row, row + 3):
            for j in range(col, col + 3):
                ch = board[i][j]
                if ch == '.':
                    continue
                if ch in hm:
                    return False
                hm.add(ch)
        return True