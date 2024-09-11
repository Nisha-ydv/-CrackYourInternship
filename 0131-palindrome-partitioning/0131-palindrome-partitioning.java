class Solution {
    List<List<String>> res=new ArrayList<>();
    int n;
    public List<List<String>> partition(String s) {
        n=s.length();
        recur(s,0,new ArrayList<>());
        return res;
    }
    public boolean isPalindrome(String s, int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public void recur(String s, int partIndex, List<String> subList){
        if(partIndex==n){
            res.add(new ArrayList<>(subList));
            return;
        }
        for( int end=partIndex;end<n;end++){
            if(isPalindrome(s,partIndex,end)){
                subList.add(s.substring(partIndex,end+1));
                recur(s,end+1,subList);
                // backtracking
                subList.remove(subList.size()-1);
            }
        }
    }
}