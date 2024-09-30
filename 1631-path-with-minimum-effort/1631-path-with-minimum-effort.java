class Solution {
    class tuple {
        int dist;
        int row;
        int col;
        public tuple(int dist, int row, int col){
            this.dist=dist;
            this.row=row;
            this.col=col;
        }
       
    }
    public int minimumEffortPath(int[][] heights) {
      PriorityQueue<tuple> pq=new PriorityQueue<>((x,y)->x.dist-y.dist);
        int n=heights.length;
        int m=heights[0].length;
        int[][] diff=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                diff[i][j]= (int)(1e9);
            }
        }
        diff[0][0]=0;
        pq.add(new tuple(0,0,0));
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        while(pq.size()!=0){
            tuple curr=pq.poll();
            int differ=curr.dist;
            int row=curr.row;
            int col=curr.col;
            if(row==n-1 && col==m-1) return differ;
            
            for(int i=0;i<4;i++){
                int newr=row+dr[i];
                int newc=col+dc[i];
                if(newr>=0 && newc>=0 && newr<n && newc<m){
                    int neweffort= Math.max(Math.abs(heights[row][col]-heights[newr][newc]), differ);
                    if(neweffort<diff[newr][newc]){
                        diff[newr][newc]=neweffort;
                        pq.add( new tuple(neweffort,newr,newc));
                    }
                }
            }
        }
        return 0;
    }
}