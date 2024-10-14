class Solution {
    public void dfs(int src, List<List<Integer>> adjlist, boolean[] visited){
        visited[src]=true;
        for(int neigh:adjlist.get(src)){
            if(!visited[neigh]){
                dfs(neigh,adjlist,visited);
            }
        }
    }
    public int removeStones(int[][] stones) {
        int n=stones.length;
      List<List<Integer>> adjlist=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjlist.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1] ){
                    adjlist.get(i).add(j);
                    adjlist.get(j).add(i);
                }
            }
        }
        int component=0;
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,adjlist,visited);
                component++;
            }
        }
        return n-component;
    }
}