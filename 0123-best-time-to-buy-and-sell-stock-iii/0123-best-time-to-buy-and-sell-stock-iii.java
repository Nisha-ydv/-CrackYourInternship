class Solution {
    public int maxProfit(int[] prices) {
       int n=prices.length;
        
        
    
        int[][][] dp=new int[n+1][2][3];
         
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                for(int ke=1;ke<=2;ke++){
              if(buy==1){
             dp[ind][buy][ke]= Math.max((-prices[ind]+dp[ind+1][0][ke]), dp[ind+1][1][ke]);
              }
               else {
                 dp[ind][buy][ke]= Math.max((prices[ind]+dp[ind+1][1][ke-1]),dp[ind+1][0][ke]);  
               } 
            }  
        }
    }
        
        
        return dp[0][1][2]; 
    }
}