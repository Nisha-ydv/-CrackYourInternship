class Solution {
    public int[] findOrder(int V, int[][] prerequisites) {
        int m=prerequisites.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int indegre[]=new int[V];
        for(int u=0;u<V;u++){
            for(int v: adj.get(u)){
                indegre[v]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegre[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            int curr=q.poll();
            res.add(curr);
            for(int neigh:adj.get(curr)){
                indegre[neigh]--;
                if(indegre[neigh]==0){
                    q.add(neigh);
                }
            }
        }
        if(res.size()!=V) return new int[0];
        int[] ans=new int[V];
        for(int i=0;i<res.size();i++){
            ans[i]=res.get(i);
        }
        return ans;
    }
}
