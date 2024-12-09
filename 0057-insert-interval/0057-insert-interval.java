class Solution {
    public int[][] insert(int[][] interval, int[] newInterval) {
     ArrayList<int[]> res=new ArrayList<>();
        int i=0;
        int n=interval.length;
        while(i<n && interval[i][1]<newInterval[0]){
            res.add(interval[i]);
            i++;
        }
        while(i<n && newInterval[1]>=interval[i][0]){
            newInterval[0]=Math.min(newInterval[0],interval[i][0]);
            newInterval[1]=Math.max(newInterval[1],interval[i][1]);
            i++;
        }
        res.add(newInterval);
        while(i<n){
            res.add(interval[i]);
            i++;
        }
        return res.toArray(new int[res.size()][2]);   
    }
}