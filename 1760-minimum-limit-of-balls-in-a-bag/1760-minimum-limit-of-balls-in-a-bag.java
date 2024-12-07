class Solution {
    public int maxnumber(int[] nums){
        int max=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }
        return max;
    }
    public boolean ispossible(int[] nums, int maxballallowed, int maxOperation){
        int operation=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]>maxballallowed){
                int bag=(int)Math.ceil(nums[i]/(double)maxballallowed);
                operation+=bag-1;
            }
            if(operation>maxOperation){
                return false;
            }
        }
        return true;
    }
    public int minimumSize(int[] nums, int maxOperations) {
     int left=1;
        int right=maxnumber(nums);
        int result=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(ispossible(nums, mid, maxOperations)){
                result=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return result;
    }
}