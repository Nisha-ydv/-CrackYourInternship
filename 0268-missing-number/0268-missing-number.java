// class Solution {
//     public int missingNumber(int[] nums) {
//         Arrays.sort(nums);
//         for(int i=0;i<nums.length;i++){
//            if(nums[i]!=i) return i; 
//         }
//         return nums.length;
//     }
// }

class Solution{
    public int missingNumber(int[] nums){
        for(int i=0;i<=nums.length;i++){
            boolean found=false;
            for(int j=0;j<nums.length;j++){
              if(i==nums[j]){
                  found =true;
                  break;
              } 
                
            }
            if(found==false){
                return i;
            }
        }
        return -1;
    }
}