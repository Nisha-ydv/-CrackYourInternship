// class Solution {
//     public int minLength(String s) {
//         Stack<Character> st=new Stack<>();
//        for(int i=0;i<s.length();i++){
//            char ch= s.charAt(i);
//            if(st.isEmpty()){
//                st.push(ch);
//            }
//           else  if(ch=='B' && st.peek()=='A'){
//                st.pop();
//            }
//          else   if(ch=='D' && st.peek()=='C'){
//                st.pop();
//            }
//            else{
//                st.push(ch);
//            }
           
//        }
//         return st.size();
//     }
// }



class Solution {
    public int minLength(String s) {
        int n=s.length();
        char[] str=s.toCharArray();
        int w=0;
        for(int r=0;r<n;r++){
          if(w==0){
              str[w]=str[r];
              w++;
              continue;
          } 
            if(str[w-1]=='A' && str[r]=='B'){
                w--;
            }
            else if(str[w-1]=='C' && str[r]=='D'){
                w--;
            }
            else{
                str[w]=str[r];
                w++;
            }
        }
        return w;
    }
}