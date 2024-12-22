// class Solution {
//     public int maxProfit(int k, int[] prices) {
        
//         int n=prices.length;
//         if(k==0) return 0;
        
    
//         int[][][] dp=new int[n+2][2][k+1];
         
//         for(int ind=n-1;ind>=0;ind--){
//             for(int buy=0;buy<=1;buy++){
//                 for(int ke=1;ke<=k;ke++){
//               if(buy==1){
//              dp[ind][buy][ke]= Math.max((-prices[ind]+dp[ind+1][0][ke]), dp[ind+1][1][ke]);
//               }
//                else {
//                  dp[ind][buy][ke]= Math.max((prices[ind]+dp[ind+2][1][ke-1]),dp[ind+1][0][ke]);  
//                } 
//             }  
//         }
//     }
        
        
//         return dp[0][1][k];
//     }
// }

class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][][] dp = new int[n + 1][2][k + 1];
        
        // As dp array is initialized to 0, we have already covered the base case
        
        // Iterate through the array and fill in the dp array
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= k; cap++) {
                    if (buy == 0) { // We can buy the stock
                        dp[ind][buy][cap] = Math.max(0 + dp[ind + 1][0][cap], 
                                -prices[ind] + dp[ind + 1][1][cap]);
                    } else { // We can sell the stock
                        dp[ind][buy][cap] = Math.max(0 + dp[ind + 1][1][cap],
                                prices[ind] + dp[ind + 1][0][cap - 1]);
                    }
                }
            }
        }
        
        return dp[0][0][k];
    }
}
