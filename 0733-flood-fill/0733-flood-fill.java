class Solution {
//     private void dfs(int[][] image, int row,int col,int newcolor,int oldcolor){
//         if(row>=image.length || row<0 || col>= image[0].length || col<0 || image[row][col]!=oldcolor) return;
//         image[row][col]=newcolor;
//         dfs(image,row-1,col,newcolor,oldcolor);
//         dfs(image,row+1,col,newcolor,oldcolor);
//         dfs(image,row,col-1,newcolor,oldcolor);
//         dfs(image,row,col+1,newcolor,oldcolor);

//     }
    
    public void dfs(int[][] image, int sr, int sc, int newcolor,int[] delRow,int[] delCol,int[][] ans,int inicolor){
        ans[sr][sc]=newcolor;
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<4;i++){
            int nrow=sr+delRow[i];
            int mcol=sc+delCol[i];
            if(nrow>=0 && nrow<n && mcol>=0 && mcol<m && ans[nrow][mcol]==inicolor && ans[nrow][mcol]!=newcolor){
                dfs(image,nrow,mcol,newcolor,delRow,delCol,ans,inicolor);
            }
        }
        
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newcolor) {
      // if(newcolor==image[sr][sc])  return image;
      // dfs(image,sr,sc,newcolor,image[sr][sc]);
      // return image;
        int inicolor=image[sr][sc];
        int[][] ans=image;
        int delRow[]={-1,0,1,0};
        int delCol[]={0,1,0,-1};
        dfs( image,sr,sc,newcolor,delRow,delCol,ans,inicolor);
        return ans;
    }
}