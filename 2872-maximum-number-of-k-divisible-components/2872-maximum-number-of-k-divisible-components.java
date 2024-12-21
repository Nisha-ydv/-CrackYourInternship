class Solution {
    
    long dfs(int curr, int parent,List<Integer>[] adjlist, int[] values, int k, int[] componentcount){
        long sum=0;
        for(int neighbour:adjlist[curr]){
            if(neighbour!=parent){
                sum+=dfs(neighbour, curr, adjlist, values,k, componentcount);
            }
        }
        sum+=values[curr];
        if(sum%k==0){
            componentcount[0]++;
            sum=0;
        }
        return sum;
    }
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] adjlist=new ArrayList[n];
        for(int i=0;i<n;i++){
            adjlist[i]=new ArrayList<>();
        }
        for(int edge[]:edges){
            int node1=edge[0];
            int node2=edge[1];
            adjlist[node1].add(node2);
            adjlist[node2].add(node1);
        }
        int[] componentcount=new int[1];
        dfs(0,-1, adjlist, values,k, componentcount);
        return componentcount[0];
    }
}