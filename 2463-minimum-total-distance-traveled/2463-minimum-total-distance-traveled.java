// class Solution {
//     public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        
//     }
// }

import java.util.*;

class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        int n = robot.size();
        int m = factory.length;
        
        long[][] dp = new long[n + 1][m + 1];
        
        // Initialize dp array with infinity, except dp[0][0] = 0
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }
        dp[0][0] = 0;

        for (int j = 1; j <= m; j++) {
            int factoryPosition = factory[j - 1][0];
            int limit = factory[j - 1][1];
            dp[0][j] = 0;  // No robots to assign, hence zero distance

            for (int i = 1; i <= n; i++) {
                dp[i][j] = dp[i][j - 1];  // Option to not assign any robot to the current factory
                long distanceSum = 0;

                for (int k = 1; k <= Math.min(limit, i); k++) {
                    distanceSum += Math.abs(robot.get(i - k) - factoryPosition);

                    if (dp[i - k][j - 1] != Long.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - k][j - 1] + distanceSum);
                    }
                }
            }
        }
        
        return dp[n][m];
    }
}
