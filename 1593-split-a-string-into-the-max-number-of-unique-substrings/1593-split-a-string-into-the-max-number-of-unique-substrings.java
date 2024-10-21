class Solution {
    int maxcount;
    public void backtrack(String s, HashSet<String> set, int index){
        int n=s.length();
        if(index==s.length()){
            maxcount=Math.max(maxcount,set.size());
            return;
        }
        for(int i=index;i<n;i++){
            String sub=s.substring(index,i+1);
            if(!set.contains(sub)){
                set.add(sub);
                backtrack(s,set,i+1);
                set.remove(sub);
                
            }
        }
    }
    public int maxUniqueSplit(String s) {
       maxcount=0;
        HashSet<String> set=new HashSet<>();
        backtrack(s,set,0);
        return maxcount;
    }
}