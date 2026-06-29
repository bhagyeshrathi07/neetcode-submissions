class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int ROW = grid.length;
        int COL = grid[0].length;

        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                if(grid[r][c] == 0) {
                    q.offer(new int[] {r,c});
                }
            }
        }
        if (q.size() == 0) return;
        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] treasure = q.poll();
                int treasureRow = treasure[0];
                int treasureCol = treasure[1];
                for(int[] dir : directions) {
                    int nr = dir[0]+treasureRow;
                    int nc = dir[1]+treasureCol;
                    if (nr < 0 || nc < 0 || nr >= ROW || nc >= COL || grid[nr][nc] != Integer.MAX_VALUE) {
                        continue;
                    }
                    q.offer(new int[] {nr, nc});
                    grid[nr][nc] = grid[treasureRow][treasureCol] + 1;
                }
            }
        }
    }
}
