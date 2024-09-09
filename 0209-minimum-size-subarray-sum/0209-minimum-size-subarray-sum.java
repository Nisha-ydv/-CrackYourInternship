class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       int minLenWindow=Integer.MAX_VALUE;
        int sum=0;
        int low=0;
        int high=0;
        while(high<nums.length){
            sum+=nums[high];
            high++;
            while(sum>=target){
                int windowSize=high-low;
                minLenWindow=Math.min(minLenWindow,windowSize);
                sum-=nums[low];
                low++;
            }
        }
        return minLenWindow==Integer.MAX_VALUE ? 0:minLenWindow;
    }
}