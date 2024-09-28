class Solution {
    public int[][] updateMatrix(int[][] mat) {
       int m=mat.length;
        int n=mat[0].length;
        int[][] result=new int[m][n];
        
        Queue<int[]> q=new LinkedList<>();
        int[][] direction={{-1,0,1,0},{0,1,0,-1}};
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    result[i][j]=0;
                    q.add(new int[] {i,j});
                }
                else{
                    result[i][j]=-1;
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int row=curr[0];
            int col=curr[1];
            for(int i=0;i<4;i++){
                int new_row=row+direction[0][i];
                int new_col=col+direction[1][i];
                
                if(new_row>=0 && new_row<m && new_col>=0 && new_col<n && result[new_row][new_col]==-1){
                    result[new_row][new_col]=result[row][col]+1;
                    q.add(new int[] {new_row,new_col});
                }
            }
        }
        return result;
    }
}