class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        row = len(grid)
        col = len(grid[0])
        fresh = 0
        q = deque()

        for i in range(row):
            for j in range(col):
                if grid[i][j] == 1:
                    fresh += 1
                elif grid[i][j] == 2:
                    q.append((i, j))

        time = 0
        dr = [0, 1, 0, -1]
        dc = [1, 0, -1, 0]

        while q and fresh > 0:
            size = len(q)
            for _ in range(size):
                curr = q.popleft()
                currr = curr[0]
                currc = curr[1]
                for k in range(4):
                    nr = currr + dr[k]
                    nc = currc + dc[k]
                    if nr >= 0 and nc >= 0 and nr < row and nc < col and grid[nr][nc] == 1:
                        grid[nr][nc] = 2
                        fresh -= 1
                        q.append((nr, nc))
            time += 1
        
        return time if fresh == 0 else -1