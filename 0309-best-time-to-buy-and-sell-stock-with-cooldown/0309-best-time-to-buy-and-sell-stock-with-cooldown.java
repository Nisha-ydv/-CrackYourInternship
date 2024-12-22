class Solution {
    public  int f(int ind , int buy, int n,int[] prices,int[][] dp){
        if(ind>=n) return 0;
        if(dp[ind][buy]!=-1) return dp[ind][buy];
        if(buy==1){
            return dp[ind][buy]= Math.max((-prices[ind]+f(ind+1,0,n,prices, dp)), f(ind+1, 1,n, prices, dp));
        }
        return dp[ind][buy]= Math.max((prices[ind]+f(ind+2,1,n, prices, dp)),f(ind+1,0,n, prices, dp));
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                dp[i][j]=-1;
            }
        }
        
        return f(0,1, n,prices,dp);
    }
}