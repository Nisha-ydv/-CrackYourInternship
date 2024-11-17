// class Solution {
//     public int[][] updateMatrix(int[][] mat) {
//        int m=mat.length;
//         int n=mat[0].length;
//         int[][] result=new int[m][n];
        
//         Queue<int[]> q=new LinkedList<>();
//         int[][] direction={{-1,0,1,0},{0,1,0,-1}};
        
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(mat[i][j]==0){
//                     result[i][j]=0;
//                     q.add(new int[] {i,j});
//                 }
//                 else{
//                     result[i][j]=-1;
//                 }
//             }
//         }
        
//         while(!q.isEmpty()){
//             int[] curr=q.poll();
//             int row=curr[0];
//             int col=curr[1];
//             for(int i=0;i<4;i++){
//                 int new_row=row+direction[0][i];
//                 int new_col=col+direction[1][i];
                
//                 if(new_row>=0 && new_row<m && new_col>=0 && new_col<n && result[new_row][new_col]==-1){
//                     result[new_row][new_col]=result[row][col]+1;
//                     q.add(new int[] {new_row,new_col});
//                 }
//             }
//         }
//         return result;
//     }
// }

class Solution {
    public class node{
        int first;
        int second;
        int third;
        public node(int first, int second, int third){
            this.first=first;
            this.second=second;
            this.third=third;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
      int n=mat.length;
        int m= mat[0].length;
        int[][] vis=new int[n][m];
        int[][] dis=new int[n][m];
        Queue<node> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               if(mat[i][j]==0){
                   vis[i][j]=1;
                   q.add(new node(i,j,0));
               } 
            }
        }
        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            int step=q.peek().third;
            q.remove();
            dis[row][col]=step;
            int rowDir[]={-1,0,1,0};
            int colDir[]={0,1,0,-1};
            for(int i=0;i<4;i++){
              int newrow=row+rowDir[i];
                int newcol=col+colDir[i];
                if(newrow>=0 && newrow<n && newcol>=0 && newcol<m && vis[newrow][newcol]==0){
                    vis[newrow][newcol]=1;
                    q.add(new node(newrow, newcol,step+1));
                }
            }
        }
        return dis;
    }
}