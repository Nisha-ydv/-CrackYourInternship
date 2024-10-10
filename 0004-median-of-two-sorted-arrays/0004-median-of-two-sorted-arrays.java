// import java.util.*;
// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//       Queue<Integer> q1=new LinkedList<>();
//       Queue<Integer> q2=new LinkedList<>();
//       for(int i=0;i<nums1.length;i++){
//         q1.add(nums1[i]);
//         }
//     for(int i=0;i<nums2.length;i++){
//         q2.add(nums2[i]);
//     }
//     int[] arr=new int[nums1.length+nums2.length];
//     int count=0;
//     while(q1.size()>0 && q2.size()>0){
//      if(q1.peek()>q2.peek() && q1.size()>0 && q2.size()>0){
//         arr[count]=q2.remove();
//         count++;
//      }
//      else  if(q1.peek()<q2.peek() ){
//       arr[count]=q1.remove();
//       count++;
//      }
     
//     }
//       if(q1.size()==0 && q2.size()>0){
//         arr[count]=q2.remove();
//         count++;
//     }
//     else if (q2.size()==0 && q1.size()>0){
//         arr[count]=q1.remove();
//         count++;
//     }
//     int n=arr.length;
//     if(n%2!=0){
//         return arr[n/2];
//     }
//     else{
//         return (double)(arr[n/2]+arr[(n/2)-1])/2;
//     }

//     }
// }


class Solution{
     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
   if(nums1.length>nums2.length){
       return findMedianSortedArrays( nums2,  nums1);
   }
         int n1=nums1.length;
         int n2=nums2.length;
         int N=n1+n2;
         int start=0;
         int end=n1;
         while(start<=end){
             int cut1=start+(end-start)/2;
             int cut2=N/2-cut1;
             
             // l1,l2,r1,r2
             int l1=(cut1==0)?Integer.MIN_VALUE:nums1[cut1-1];
             int l2=(cut2==0)?Integer.MIN_VALUE:nums2[cut2-1];
             int r1=(cut1==n1)?Integer.MAX_VALUE:nums1[cut1];
             int r2=(cut2==n2)?Integer.MAX_VALUE:nums2[cut2];
             
             
             // check is cut valid
             if(l1<=r2 && l2<=r1){
                 // if N is odd
                 if(N%2!=0){
                     return (double)Math.min(r1,r2);
                 }
                 else{
                     return (double)((Math.max(l1,l2)+Math.min(r1,r2))/2.0);
                 }
             }
             else if(l1>r2){
                 end=cut1-1;
             }
             else{
                 start=cut1+1;
             }
             
         }
         return 0.0;
     }      
         
}