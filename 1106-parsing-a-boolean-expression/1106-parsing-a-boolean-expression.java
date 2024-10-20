class Solution {
    public boolean find(ArrayList<Character> list, char val){
        for(char ch: list){
            if(ch==val){
                return true;
            }
        }
        return false;
    }
    public char evaluate(ArrayList<Character> list, char op){
        if(op=='&'){
            if(find(list,'f')){
                return 'f';
            }
            else{
                return 't';
            }
        }
        else if(op=='|'){
            if(find(list,'t')){
                return 't';
            }
            else{
                return 'f';
            }
        }
        else{
            return (list.get(0)=='t'?'f':'t');
        }
    }
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st=new Stack<>();
        int n=expression.length();
        for(int i=0;i<n;i++){
            char ch=expression.charAt(i);
            if(ch==')'){
                ArrayList<Character> list=new ArrayList<>();
                while(st.peek()!='('){
                    list.add(st.pop());
                }
                st.pop();
                char op=st.pop();
                char ans=evaluate(list,op);
                st.push(ans);
            }
            else{
                if(ch!=','){
                    st.push(ch);
                }
            }
        }
        return st.peek()=='t';
    }
}