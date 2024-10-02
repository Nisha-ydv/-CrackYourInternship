class Solution {
    
    
    public int dijakstra(int n, ArrayList<ArrayList<ArrayList<Integer>>> adj,int src,int Threshold ){
        int dist[]=new int[n];
        for(int i=0;i<n;i++){
            //dist[i]=Integer.MAX_VALUE;
             dist[i]=Threshold+1;
        }
        dist[src]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[1]-b[1];
            }
        });
        pq.offer( new int[] {src,0});
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int node=curr[0];
            int d=curr[1];
            for(ArrayList<Integer> neigh:adj.get(node)){
                int newdist=d+neigh.get(1);
                int adjnode=neigh.get(0);
                if(newdist<dist[adjnode]){
                    dist[adjnode]=newdist;
                    pq.offer( new int[]{adjnode,dist[adjnode]});
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(dist[i]<=Threshold){
               count++; 
            }
        }
        return count;
    }
    public int findTheCity(int n, int[][] edges, int Threshold) {
      ArrayList<ArrayList<ArrayList<Integer>>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int from=edge[0];
            int to=edge[1];
            int d=edge[2];
            ArrayList<Integer> t1=new ArrayList<>();
            ArrayList<Integer> t2=new ArrayList<>();
            t1.add(to);
            t1.add(d);
            t2.add(from);
            t2.add(d);
            adj.get(from).add(t1);
            adj.get(to).add(t2);
        }
        
        int mincount=Integer.MAX_VALUE;
        int ans=-1;
        for(int i=0;i<n;i++){
            int count=dijakstra(n,adj,i, Threshold);
            if(count<=mincount){
                ans=i;
                mincount=count;
            }
        }
        return ans;
    }
}