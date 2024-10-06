class Solution {
    private void dfs(int method,List<List<Integer>> graph,Set<Integer> suspicious){
        if(suspicious.contains(method)) return;
        suspicious.add(method);
        for(int nextMethod:graph.get(method)){
            dfs(nextMethod,graph,suspicious);
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
     List<List<Integer>> graph=new ArrayList<>();
     for(int i=0;i<n;i++){
        graph.add(new ArrayList<>());
     } 

     for(int[] invocation:invocations){
        graph.get(invocation[0]).add(invocation[1]);
     } 
     Set<Integer>  suspicious=new HashSet<>();
     dfs(k,graph,suspicious);
     
     for(int[] invocation:invocations){
        if(!suspicious.contains(invocation[0]) && suspicious.contains(invocation[1])){
            List<Integer> allMethods=new ArrayList<>();
            for(int i=0;i<n;i++){
                allMethods.add(i);
            }
            return allMethods;
        }
     }
     List<Integer> remainingMethodssec=new ArrayList<>();
     for(int i=0;i<n;i++){
        if(!suspicious.contains(i)){
            remainingMethodssec.add(i);
        }
     }
     return remainingMethodssec;
    }
}