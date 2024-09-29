class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V=graph.length;
       List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree=new int[V];
        for(int u=0;u<V;u++){
            for(int v: graph[u]){
                adj.get(v).add(u);
                indegree[u]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        List<Integer> safenode=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            safenode.add(curr);
            for(int neigh:adj.get(curr)){
                indegree[neigh]--;
                if(indegree[neigh]==0) q.add(neigh);
            }
        }
        Collections.sort(safenode);
        return safenode;
    }
}