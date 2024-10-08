class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum=0;
        int result=0;
        Map<Integer,Integer> presum=new HashMap<>();
        presum.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(presum.containsKey(sum-k)){
                result+=presum.get(sum-k);
            }
            presum.put(sum,presum.getOrDefault(sum,0)+1);
        }
        return result;
    }
}