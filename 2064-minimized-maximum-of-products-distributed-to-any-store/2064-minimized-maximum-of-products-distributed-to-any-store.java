// class Solution {
//     public boolean isPossible(int mid,int[] quantities,int n){
//          int storecount=0;
//         for(int i=0;i<quantities.length;i++){
//             storecount+=quantities[i]/mid;
//             if(quantities[i]%mid!=0){
//                 storecount+=1;
//             }
//             if(storecount>n) return false;
//         }
//         return true;
//     }
    
//     public int minimizedMaximum(int n, int[] quantities) {
//       int start=0;
//         int end=Integer.MIN_VALUE;
//         for(int i=0;i<quantities.length;i++){
//             if(end<quantities[i]){
//                 end=quantities[i];
//             }
//         }
//         int res=-1;
       
//         while(start<=end){
//             int mid=start+(end-start)/2;;
//             if(isPossible(mid,quantities,n)){
//                 res=mid;
//                 end=mid-1;
                
//             }
//             else{
//                 start=mid+1;
//             }
//         }
//         return res;
//     }
// }


class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        
        int start = 1; // to avoid divide by zero error
        int end = Integer.MIN_VALUE; // for finding the max value.

        for(int i=0;i<quantities.length;i++){
            if(quantities[i]>end){
                end = quantities[i];
            }
        }

        int res = -1;

        while(start<=end){
            int mid = start + (end-start)/2;
            if(isDistributionPossible(quantities, mid, n)){
                res = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return res;
    }
    boolean isDistributionPossible(int quantities[], int maxProducts, int stores) {
        int storeCount = 0;
        for(int i=0;i<quantities.length;i++){
            storeCount += quantities[i]/maxProducts;
            if(quantities[i]%maxProducts!=0){
                storeCount+=1;
            }
            if(storeCount>stores) {
                return false;
            }
        }
        return true;

    }
}
