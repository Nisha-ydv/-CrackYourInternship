class Solution {
    public long continuousSubarrays(int[] nums) {
        int n=nums.length;
        int start=0;
        int end=0;
        long count=0;
        TreeMap<Integer, Integer> map=new TreeMap<>();
        while(end<n){
            map.put(nums[end], map.getOrDefault(nums[end],0)+1);
            while((map.lastEntry().getKey()-map.firstEntry().getKey())>2){
                map.put(nums[start], map.getOrDefault(nums[start],0)-1);
                if(map.get(nums[start])==0){
                    map.remove(nums[start]);
                }
                start++;
            }
            count+=end-start+1;
            end++;
        }
        return count;
    }
}