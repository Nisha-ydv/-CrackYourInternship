class Solution {
    public String compressedString(String word) {
       StringBuilder st= new StringBuilder("");
        int n=word.length();
        int i=0;
        while(i<n){
          int  count=0;
            char ch=word.charAt(i);
            while(i<n && count< 9 && word.charAt(i)==ch){
                i++;
                count++;
            }
            st.append(count).append(ch);
        }
        return st.toString();
    }
}