class Solution {
    public int minGroups(int[][] intervals) {
     TreeMap<Integer,Integer> treemap=new TreeMap<>();
        for(int[] interval:intervals){
            int starttime=interval[0];
            int endtime=interval[1]+1;
            treemap.put(starttime,treemap.getOrDefault(starttime,0)+1);
            treemap.put(endtime,treemap.getOrDefault(endtime,0)-1);
        }
        int maxcount=0;
        int currentcount=0;
        for(Map.Entry<Integer,Integer> entry:treemap.entrySet()){
            currentcount+=entry.getValue();
            maxcount=Math.max(maxcount,currentcount);
        }
        return maxcount;
    }
}