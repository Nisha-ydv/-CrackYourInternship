// class Solution {
//     public int countSquares(int[][] matrix) {
        
//     }
// }

class Solution {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int count = 0;
        
        // DP array to store the size of the largest square ending at each cell
        int[][] dp = new int[rows][cols];
        
        // Iterate through each cell in the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Only consider cells with '1' as potential square endings
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        // For cells in the first row or column, only 1x1 squares are possible
                        dp[i][j] = 1;
                    } else {
                        // Determine the largest square ending at (i, j)
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    }
                    // Add the square count to the total
                    count += dp[i][j];
                }
            }
        }
        
        return count;
    }
}
