class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int [] prev = new int[n];
        Arrays.fill(prev,Integer.MAX_VALUE);
        prev[src]=0;
        for(int i=0;i<=k;i++){
            int cur[]= new int[n];
            for(int j=0;j<n;j++){
                cur[j]= prev[j];
            }
            for(int e[]:flights){
                int u=e[0],v=e[1],wt=e[2];
                if(prev[u] != Integer.MAX_VALUE && prev[u]+wt <cur[v]){
                    cur[v] = prev[u]+wt;
                }
            }
            for(int j=0;j<n;j++){
                prev[j]=cur[j];
            }
        }return prev[dst]==Integer.MAX_VALUE ?-1:prev[dst];
    }
}