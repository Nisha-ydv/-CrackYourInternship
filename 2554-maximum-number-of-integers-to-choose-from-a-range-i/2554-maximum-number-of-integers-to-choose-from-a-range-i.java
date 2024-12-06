// class Solution {
//     public int maxCount(int[] banned, int n, int maxSum) {
//         int sum=0;
//         int count=0;
//         for(int i=1;i<=n;i++){
//         boolean isbanned=false;
//             for(int j=0;j<banned.length;j++){
//                 if(i==banned[j]){
//                     isbanned=true;
//                     break;
//                 }
                
//             }
//         if(isbanned){
//                  continue;                     
//                 }
//                 if(sum+i>maxSum){
//                     break;
//                 }
                
//             sum+=i;
//             count++;
//     }
            
        
//         return count;
//     }
// }
class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
       int sum=0;
       int count=0;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<banned.length;i++){
            set.add(banned[i]);
        }
        for(int i=1;i<=n;i++){
            if(!set.contains(i)){
             if(sum+i>maxSum){
                 break;
             } 
                sum+=i;
                count++;
            }
                
            
        }
        return count;
        
}
}