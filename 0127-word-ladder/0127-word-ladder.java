class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       Set<String> st=new HashSet<>();
        Queue<String> q =new LinkedList<>();
        boolean ispresent=false;
        for(String word: wordList){
            st.add(word);
            if(st.contains(endWord)){
                 ispresent=true;
            }
            
        }
        if(ispresent==false){
            return 0;
        }
        q.offer(beginWord);
        int depth=0;
        while(q.size()!=0){
            depth+=1;
            int lsize=q.size();
            while(lsize>0){
                String curr= q.poll();
                
                for(int i=0;i<curr.length();i++){
                     
                    for(char c='a';c<='z';c++){
                        char newcharArray[]=curr.toCharArray();
                        newcharArray[i]=c;
                        String replaceword=new String(newcharArray);
                        if(curr.equals(replaceword)) continue;
                        if(replaceword.equals(endWord)) return depth+1;
                        if(st.contains(replaceword)==true){
                            q.add(replaceword);
                            st.remove(replaceword);
                        }
                    }
                }
                lsize--;
            }
        }
        return 0;
        
    }
}