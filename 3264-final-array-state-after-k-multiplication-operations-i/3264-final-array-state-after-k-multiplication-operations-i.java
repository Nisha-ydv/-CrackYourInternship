class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
     int n=nums.length;
        
        while(k>0){
            int min=Integer.MAX_VALUE;
            int index=-1;
          for(int i=0;i<n;i++){
            if(min>nums[i]){
                min=nums[i];
                index=i;
            }
              
          } 
            nums[index]=nums[index]*multiplier;
            k--;
            
        }
        return nums;
        
    }
}