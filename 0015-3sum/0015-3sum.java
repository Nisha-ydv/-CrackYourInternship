class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
     if(arr==null || arr.length<3) return new ArrayList<>();
        
        // sort thr element
        Arrays.sort(arr);
        Set<List<Integer>> result=new HashSet<>();
        
        // now fix the first element and find the other two element
        for(int i=0;i<arr.length;i++){
            int left=i+1;
            int right=arr.length-1;
            while(left<right){
                int sum=arr[i]+arr[left]+arr[right];
                if(sum==0){
                    
                    // add the set and move to find other triplets
                    result.add(Arrays.asList(arr[i],arr[left], arr[right]));
                    left++;
                    right--;
                    
                }
                
                else if(sum<0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return new ArrayList<>(result);
        
    }
}