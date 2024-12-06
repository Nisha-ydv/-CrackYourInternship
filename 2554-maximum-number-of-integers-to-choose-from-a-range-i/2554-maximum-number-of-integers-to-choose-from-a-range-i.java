class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int sum=0;
        int count=0;
        for(int i=1;i<=n;i++){
        boolean isbanned=false;
            for(int j=0;j<banned.length;j++){
                if(i==banned[j]){
                    isbanned=true;
                    break;
                }
                
            }
        if(isbanned){
                 continue;                     
                }
                if(sum+i>maxSum){
                    break;
                }
                
            sum+=i;
            count++;
    }
            
        
        return count;
    }
}
// class Solution {
//     public int maxCount(int[] banned, int n, int maxSum) {
//         int sum = 0; // Tracks the sum of chosen integers
//         int count = 0; // Tracks the number of chosen integers

//         for (int i = 1; i <= n; i++) {
//             boolean isBanned = false; // Flag to check if `i` is in the banned array

//             // Check if `i` is in the banned array
//             for (int j = 0; j < banned.length; j++) {
//                 if (i == banned[j]) {
//                     isBanned = true; // Mark as banned
//                     break; // Exit the inner loop early
//                 }
//             }

//             // Skip the current number if it is banned
//             if (isBanned) {
//                 continue;
//             }

//             // Check if adding `i` exceeds maxSum
//             if (sum + i > maxSum) {
//                 break; // Exit the loop as no more numbers can be added
//             }

//             // Add the current number to the sum and increment count
//             sum += i;
//             count++;
//         }

//         return count; // Return the total count of chosen numbers
//     }
// }
