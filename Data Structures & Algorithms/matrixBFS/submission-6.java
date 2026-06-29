class Solution {
    public int shortestPath(int[][] grid) {
        int ROW = grid.length; 
        int COL = grid[0].length;
        boolean[][] visited = new boolean[ROW][COL];
        return bfs(grid, 0, 0, visited);
    }

    public int bfs(int[][] grid, int r, int c, boolean[][] visit) {
        int ROW = grid.length;
        int COL = grid[0].length;

        if(grid[r][c] == 1) return -1;

        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {r, c});
        visit[r][c] = true;
        
        int length = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] cell = queue.pollFirst();
                int curRow = cell[0];
                int curCol = cell[1];
                if(curRow == ROW-1 && curCol == COL-1) {
                    return length;
                }

                int[][] neighbors = {{0,1},{1,0},{0,-1},{-1,0}};

                for(int[] neighbor : neighbors) {
                    int newR = curRow + neighbor[0];
                    int newC = curCol + neighbor[1];

                    if(newR < 0 || newC < 0 || newR == ROW || newC == COL || visit[newR][newC] == true || grid[newR][newC] == 1) {
                        continue;
                    }
                    queue.add(new int[] {newR, newC});
                    visit[newR][newC] = true;
                }
            }
            length++;
        }
        return -1;
    }
}
