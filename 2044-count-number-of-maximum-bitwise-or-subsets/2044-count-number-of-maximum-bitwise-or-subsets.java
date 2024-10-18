class Solution {
    public int recur(int index,int nums[],int curOr,int targetOr){
        if(index==nums.length){
            return (curOr==targetOr)?1:0;
        }
        int pickcount=recur(index+1,nums,curOr|nums[index],targetOr);
        int nopickcount=recur(index+1,nums,curOr,targetOr);
        return pickcount + nopickcount;
    }
    public int countMaxOrSubsets(int[] nums) {
        int targetOr=0;
        for(int num: nums){
            targetOr|=num;
        }
        return recur(0,nums,0,targetOr);
    }
}