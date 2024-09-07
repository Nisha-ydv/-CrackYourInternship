class Solution {
    public double minimumAverage(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        double minAverage=Double.MAX_VALUE;
        for(int i=0;i<n/2;i++){
            double Average= (nums[i]+nums[n-i-1])/2.0;
            if(Average<minAverage){
               minAverage=Average; 
            } 
        }
        return minAverage;
    }
}