class Solution {
    public void swap( char[] numArr, int i , int j){
        char temp=numArr[j];
                    numArr[j]=numArr[i];
                    numArr[i]=temp;
    }
    public int maximumSwap(int num) {
        int max=num;
     char [] numArr = Integer.toString(num).toCharArray();
        for(int i=0;i<numArr.length;i++){
           for(int j=i+1;j<numArr.length;j++){
                swap(numArr,i,j);
              int swapednum=Integer.parseInt(new String(numArr)); 
               max=Math.max(max,swapednum);
               swap(numArr,i,j);
               }
        }
        return max;
    }
}