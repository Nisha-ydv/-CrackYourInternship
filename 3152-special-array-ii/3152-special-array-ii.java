class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] res=new boolean[queries.length];
       int[] count= new int[nums.length];
        for(int i=1;i<nums.length;i++){
            if(nums[i]%2==0 && nums[i-1]%2!=0){
                count[i]=count[i-1]+0;
            }
            else if(nums[i]%2!=0 && nums[i-1]%2==0){
                count[i]=count[i-1]+0;
            }
            else{
                count[i]=count[i-1]+1;
            }
        }
        for(int i=0;i<queries.length;i++){
            int x= queries[i][0];
            int y=queries[i][1];
            if((count[y]-count[x])!=0){
                res[i]=false;
            }
            else{
                res[i]=true;
            }
        }
        return res;
    }
}