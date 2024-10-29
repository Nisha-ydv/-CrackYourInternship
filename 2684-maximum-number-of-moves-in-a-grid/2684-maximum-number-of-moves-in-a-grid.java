// class Solution {
//     public int maxMoves(int[][] grid) {
        
//     }
// }

class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];
        
        int maxMoves = 0;
        for (int i = 0; i < m; i++) {
            maxMoves = Math.max(maxMoves, dfs(grid, i, 0, memo));
        }
        
        return maxMoves;
    }
    
    private int dfs(int[][] grid, int row, int col, int[][] memo) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (col == n - 1) return 0;
        if (memo[row][col] != 0) return memo[row][col];
        
        int max = 0;
        
        // Move to (row - 1, col + 1)
        if (row > 0 && grid[row - 1][col + 1] > grid[row][col]) {
            max = Math.max(max, 1 + dfs(grid, row - 1, col + 1, memo));
        }
        
        // Move to (row, col + 1)
        if (grid[row][col + 1] > grid[row][col]) {
            max = Math.max(max, 1 + dfs(grid, row, col + 1, memo));
        }
        
        // Move to (row + 1, col + 1)
        if (row < m - 1 && grid[row + 1][col + 1] > grid[row][col]) {
            max = Math.max(max, 1 + dfs(grid, row + 1, col + 1, memo));
        }
        
        memo[row][col] = max;
        return max;
    }
}
