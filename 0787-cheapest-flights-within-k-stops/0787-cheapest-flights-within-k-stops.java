class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int [] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        for(int i=0;i<=k;i++){
            int cur[]= new int[n];
            for(int j=0;j<n;j++){
                cur[j]= dist[j];       // copy of dist array
            }
            for(int flight[]:flights){
                int u=flight[0];
                  int  v=flight[1];
                 int   wt=flight[2];
                if(dist[u] != Integer.MAX_VALUE && dist[u]+wt <cur[v]){
                    cur[v] = dist[u]+wt;
                }
            }
            for(int j=0;j<n;j++){
                dist[j]=cur[j];    // put all values of curr into dist
            }
        }return dist[dst]==Integer.MAX_VALUE ?-1:dist[dst];
    }
}