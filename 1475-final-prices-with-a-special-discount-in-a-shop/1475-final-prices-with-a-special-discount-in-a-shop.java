class Solution {
    public int[] finalPrices(int[] prices) {
        int n=prices.length;
        int i=0;
        while(i<n){
            
            for(int j=i+1;j<n;j++){
                if(prices[j]<=prices[i]){
                   prices[i]=prices[i]-prices[j]; 
                    break;
                }
                
            }
            
                i++;
        }
        return prices;
        
    }
}