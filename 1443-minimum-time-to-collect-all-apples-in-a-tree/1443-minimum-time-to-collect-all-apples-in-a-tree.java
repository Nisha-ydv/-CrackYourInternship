class Solution {
    public int dfs(int src, int parent, List<List<Integer>> adjlist,List<Boolean> hasApple ){
        int totaltime=0;
        for(int neigh:adjlist.get(src)){
            if(neigh==parent) continue;
            int timetakenBychild=dfs(neigh, src, adjlist,hasApple);
            if(timetakenBychild>0 || hasApple.get(neigh)){
                totaltime+=timetakenBychild+2;
            }
            
        }
        return totaltime;
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adjlist=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjlist.add(new ArrayList<>());
        }
        for(int edge[]:edges){
            int from=edge[0];
            int to=edge[1];
            adjlist.get(from).add(to);
            adjlist.get(to).add(from);
        }
        return dfs(0,-1,adjlist,hasApple);
    }
}