class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m= matrix.length;
        int n=matrix[0].length;
        ArrayList<Integer> ans=new ArrayList<>();
       int upperRow=0;
        int rightcol=n-1;
        int bottomRow=m-1;
        int leftcol=0;
        int count=0;
        while(count<m*n){
            // upper row
         for(int i=leftcol;i<=rightcol && count<m*n;i++){
            ans.add(matrix[upperRow][i]);
            count++;
         }
         upperRow++;
            
            // right col
            for(int i=upperRow;i<=bottomRow && count<m*n;i++){
                ans.add(matrix[i][rightcol]);
                count++;
            }
            rightcol--;

            // bottom row
            for(int i=rightcol;i>=leftcol && count<m*n;i--){
                ans.add(matrix[bottomRow][i]);
                count++;
            }
            bottomRow--;

            // left col
            for(int i= bottomRow;i>=upperRow && count<m*n;i--){
                ans.add(matrix[i][leftcol]);
                count++;
            }
            leftcol++;
            
        }
        return ans;
    }
}