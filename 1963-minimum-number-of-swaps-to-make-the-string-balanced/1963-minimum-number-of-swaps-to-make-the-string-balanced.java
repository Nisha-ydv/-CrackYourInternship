class Solution {
    public int minSwaps(String s) {
      Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='['){
                st.push(ch);
            }
            else{
                if(st.isEmpty() || st.peek()==']'){
                    st.push(ch);
                }
                else{
                    st.pop();
                }
            }
        }
        int totalcount=st.size();
        int openbracket=totalcount/2;
        return (openbracket+1)/2;
    }
}