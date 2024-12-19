class Solution {
    public boolean canPartition(int[] arr) {
        int n=arr.length;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        if(sum%2!=0) return false;
        int target=sum/2;
        boolean dp[][]=new boolean[n][target+1];
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        if(arr[0]<=target){
            dp[0][arr[0]]=true;
        }
        for(int ind=1;ind<n;ind++){
            for(int t=1;t<=target;t++){
                boolean notpick=dp[ind-1][t];
                boolean pick=false;
                if(arr[ind]<=t){
                    pick=dp[ind-1][t-arr[ind]];
                }
                dp[ind][t]=pick||notpick;
            }
        }
        return dp[n-1][target];
        
    }
}