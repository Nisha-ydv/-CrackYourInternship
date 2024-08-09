class Solution {
    
    public int[] find_nse(int[] heights){
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        int[] nse=new int[n];
        
        for(int i=n-1;i>=0;i--){
            while(st.size()>0 && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.size()==0){
                nse[i]=n;
            }
            else{
                nse[i]=st.peek();
            }
            st.push(i);
        }
        return nse;
    }
    
    public int[] find_pse(int[] heights){
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        int[] pse=new int[n];
       
        for(int i=0;i<n;i++){
            while(st.size()>0 && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.size()==0){
                pse[i]=-1;
            }
            else{
                pse[i]=st.peek();
            }
            st.push(i);
        }
        return pse;
    }
    
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] nse=find_nse( heights);
        int[] pse=find_pse( heights);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int h=heights[i];
            int w=nse[i]-pse[i]-1;
            int area=h*w;
            max=Math.max(max,area);
        }
        return max;
    }
}