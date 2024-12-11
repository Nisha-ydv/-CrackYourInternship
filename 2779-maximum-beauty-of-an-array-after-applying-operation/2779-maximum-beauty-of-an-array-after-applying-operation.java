class Solution {
    public int maximumBeauty(int[] nums, int k) {
       if(nums.length==1) return 1;
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(nums[i],max);
        }
        int[] count=new int[max+1];
        for(int num:nums){
            count[Math.max(num-k,0)]++;
            count[Math.min(num+k+1,max)]--;
            
        }
        // for(int i=1;i<count.length;i++){
        //     count[i]=count[i-1]+count[i];
        // }
        int maxsum=0;
        int cursum=0;
        for(int c:count){
            cursum+=c;
            maxsum=Math.max(cursum,maxsum);
        }
        
        // for(int i=0;i<count.length;i++){
        //     if(maxsum<count[i]){
        //       maxsum=count[i];  
        //     }
        // }
        return maxsum;
        
    }
}