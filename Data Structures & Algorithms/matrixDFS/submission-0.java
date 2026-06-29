class Solution {
    public int countPaths(int[][] grid) {
        Set<String> visited = new HashSet<>();
        return dfs(grid, visited, 0, 0);
    }

    public int dfs(int[][] grid, Set<String> visited, int r, int c) {
        
        int ROW = grid.length;
        int COL = grid[0].length;
        
        if(r < 0 || c < 0 || r >= ROW || c >= COL || visited.contains(r+","+c) || grid[r][c] == 1) {
            return 0;
        }
        if(r == ROW - 1 && c == COL-1) {
            return 1;
        }
        visited.add(r + "," + c);
        
        int count = 0;

        count += dfs(grid, visited, r+1, c);
        count += dfs(grid, visited, r-1, c);
        count += dfs(grid, visited, r, c+1);
        count += dfs(grid, visited, r, c-1);

        visited.remove(r + "," + c);
        return count;
    }
}
