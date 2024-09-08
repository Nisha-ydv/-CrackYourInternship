class Solution {
     public int[] convertHashSet(HashSet<Integer> common){
         return common.stream().mapToInt(Integer::intValue).toArray();
     }
     public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> st=new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            st.add(nums1[i]);
        }
        HashSet<Integer> common=new HashSet<>();
        for(int i=0;i<nums2.length;i++){
            if(st.contains(nums2[i])){
                common.add(nums2[i]);
            }
        }
        
       int[] arr=convertHashSet(common);
        return arr;
    }
}