// class Solution {
//     public int f(int ind, int buy, int[] prices, int n , int fee,int[][] dp){
//         if(ind==n) return 0;
//         if(dp[ind][buy]!=-1) return dp[ind][buy];
//         if(buy==1){
//             return Math.max((-prices[ind]+f(ind+1, 0, prices, n , fee, dp)), f(ind+1, 1, prices, n , fee, dp));
//         }
//         else{
//             return Math.max((prices[ind]-fee+f(ind+1, 1, prices, n , fee, dp)), f(ind+1, 0, prices, n , fee, dp));
//         }
//     }
//     public int maxProfit(int[] prices, int fee) {
//         int n=prices.length;
//         int[][] dp=new int[n][2];
        
//         for(int i=0;i<n;i++){
//             for(int j=0;j<2;j++){
//                 dp[i][j]=-1;
//             }
//         }
//         return f(0,1,prices, n, fee, dp);
//     }
// }

// class Solution {
    
//     public int maxProfit(int[] prices, int fee) {
//         int n=prices.length;
//         int[][] dp=new int[n+1][2];
        
//         for(int ind=n-1;ind>=0;ind--){
//            for(int buy=0;buy<=1;buy++){
//             if(buy==1){
//             dp[ind][buy]= Math.max((-prices[ind]+dp[ind+1][0]), dp[ind+1][1]);
//         }
//         else{
//             dp[ind][buy]= Math.max((prices[ind]-fee+dp[ind+1][1]),dp[ind+1][0]);
//         }   
//            } 
//         }
//         return dp[0][1];
//     }
// }


class Solution {
    
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int[] after=new int[2];
        int[] curr=new int[2];
        
        for(int ind=n-1;ind>=0;ind--){
           for(int buy=0;buy<=1;buy++){
            if(buy==1){
            curr[buy]= Math.max((-prices[ind]+after[0]), after[1]);
        }
        else{
            curr[buy]= Math.max((prices[ind]-fee+after[1]),after[0]);
        }   
           } 
            after=curr.clone();
        }
        return after[1];
    }
}