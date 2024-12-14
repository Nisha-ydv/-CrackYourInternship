// class Solution {
//     public long continuousSubarrays(int[] nums) {
//         int n=nums.length;
//         int start=0;
//         int end=0;
//         long count=0;
//         TreeMap<Integer, Integer> map=new TreeMap<>();
//         while(end<n){
//             map.put(nums[end], map.getOrDefault(nums[end],0)+1);
//             while((map.lastEntry().getKey()-map.firstEntry().getKey())>2){
//                 map.put(nums[start], map.getOrDefault(nums[start],0)-1);
//                 if(map.get(nums[start])==0){
//                     map.remove(nums[start]);
//                 }
//                 start++;
//             }
//             count+=end-start+1;
//             end++;
//         }
//         return count;
//     }
// }

class Solution {
    public long continuousSubarrays(int[] nums) {
        int n=nums.length;
        int start=0;
        int end=0;
        int currMin=Integer.MAX_VALUE;
        int currMax=Integer.MIN_VALUE;
        long count=0;
        while(end<n){
            currMin=Math.min(currMin,nums[end]);
             currMax=Math.max(currMax,nums[end]);
            if(currMax-currMin >2){
                start=end;
                currMin=nums[end];
                currMax=nums[end];
               while(start-1>=0 && Math.abs(nums[start-1]-nums[end])<=2){
                start--;
                currMin=Math.min(currMin,nums[start]);
                 currMax=Math.max(currMax,nums[start]);
              }
            }
           
            count+=(end-start)+1;
            end++;
        }
        return count;
    }
}