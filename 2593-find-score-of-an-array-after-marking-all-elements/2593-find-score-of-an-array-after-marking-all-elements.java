// class Solution {
//     public int min(int[] nums){
//         int index=-1;
//         int min=Integer.MAX_VALUE;
//         for(int i=0;i<nums.length;i++){
           
//            if( nums[i]!=-1 && nums[i]<min){
//                min=nums[i];
//                index=i;
               
//            }
            
//         }
//         return index;
//     }
//     public long findScore(int[] nums) {
//         if(nums.length==0){
//             return 0;
//         }
//         if(nums.length==1){
//             return nums[0];
//         }
//       long sum=0;
//         while(true){
//             int index=min(nums); 
//             if(index==-1){
//                 break;
//             }
           
//             sum+=nums[index];
//             nums[index]=-1;
//             if(index-1>=0){
//                 nums[index-1]=-1;
//             }
//             if(index+1<nums.length){
//                 nums[index+1]=-1;
//             }
//         }
       
        
//        return sum; 
        
//     }
// }
class Solution {
    public long findScore(int[] nums) {
        int n=nums.length;
        int[][] copy=new int[n][2];
        for(int i=0;i<n;i++){
            copy[i][0]=nums[i];
            copy[i][1]=i;
        }
        long res=0;
        Arrays.sort(copy,(a,b)-> a[0]-b[0]);
        for(int i=0;i<n;i++){
           int element=copy[i][0];
            int ind=copy[i][1];
            if(nums[ind]<0) continue;
                res+=nums[ind];
                nums[ind]=-nums[ind];
            
            if(ind-1>=0 && nums[ind-1]>0){
                nums[ind-1]=-nums[ind-1];
            }
            if(ind+1<n && nums[ind+1]>0){
                nums[ind+1]=-nums[ind+1];
            }
        }
        return res;
    }
}