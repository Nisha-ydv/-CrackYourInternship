// class Solution {
//     public int minAddToMakeValid(String s) {
//        Stack<Character> st=new Stack<>();
//         for(int i=0;i<s.length();i++){
//             char ch=s.charAt(i);
//             if(ch=='(' || st.isEmpty()){
//                 st.push(ch);
//             }
//             else if( st.peek()==')'){
//                 st.push(ch);
//             }
//             else{
//                 st.pop();
//             }
//         }
//         return st.size();
//     }
// }



class Solution {
    public int minAddToMakeValid(String s) {
       int open=0;
        int close=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(' ){
                open++;
            }
            else if( open<=0){
                close++;
            }
            else{
                open--;
            }
        }
        return (open+close);
    }
}