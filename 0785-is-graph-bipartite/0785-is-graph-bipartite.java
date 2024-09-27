class Solution {
    public boolean isBipartite(int[][] graph) {
        int len=graph.length;
        int[] color=new int[len];
        for(int i=0;i<len;i++){
            if(color[i]==1 || color[i]==-1) continue;
            Queue<Integer> q=new LinkedList<>();
            q.add(i);
            color[i]=1;
            while(!q.isEmpty()){
                int curr=q.poll();
                for(int next:graph[curr]){
                    if(color[next]==0){
                        color[next]=-color[curr];
                        q.add(next);
                    }
                    if(color[next]==color[curr]) return false;
                }
            }
        }
        return true;
    }
}