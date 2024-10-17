// class Solution {
//     public void swap( char[] numArr, int i , int j){
//         char temp=numArr[j];
//                     numArr[j]=numArr[i];
//                     numArr[i]=temp;
//     }
//     public int maximumSwap(int num) {
//         int max=num;
//      char [] numArr = Integer.toString(num).toCharArray();
//         for(int i=0;i<numArr.length;i++){
//            for(int j=i+1;j<numArr.length;j++){
//                 swap(numArr,i,j);
//               int swapednum=Integer.parseInt(new String(numArr)); 
//                max=Math.max(max,swapednum);
//                swap(numArr,i,j);
//                }
//         }
//         return max;
//     }
// }


class Solution{
   public int maximumSwap(int num) {
       char[] arr= Integer.toString(num).toCharArray();
       int n= arr.length;
       char maxElement=arr[n-1];
       int maxIdx=n-1;
       int index1=-1;
       int index2=-1;
      for(int i=n-2;i>=0;i--){
          if(arr[i]>maxElement){
              maxElement=arr[i];
              maxIdx=i;
          }
          else if(arr[i]<maxElement){
              index1=i;
              index2=maxIdx;
          }
      } 
       if(index1!=-1){
           char temp=arr[index1];
           arr[index1]=arr[index2];
           arr[index2]=temp;
       }
       return Integer.parseInt(new String(arr));
   }  
}