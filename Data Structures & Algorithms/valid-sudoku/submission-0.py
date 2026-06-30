class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        # iterate over the grid
        # use 3 hashmaps for row, col, grid (resue in each iteration)
        # if element is already in hashmap return false
        # 
        # at the end return true
        rows = defaultdict(set)
        cols = defaultdict(set)
        grids = defaultdict(set)

        for r in range(len(board)):
            for c in range(len(board[0])):
                if board[r][c] == '.':
                    continue
                
                if board[r][c] in rows[r] or board[r][c] in cols[c] or board[r][c] in grids[r//3, c//3]:
                    return False

                rows[r].add(board[r][c])
                cols[c].add(board[r][c])
                grids[r//3, c//3].add(board[r][c])

        return True
    