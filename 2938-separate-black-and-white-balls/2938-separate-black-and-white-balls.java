class Solution {
    public long minimumSteps(String s) {
        int n=s.length();
      int last=0;
        long swapcount=0;
        for(int i=0;i<n;i++){
          char ch=s.charAt(i);
            if(ch=='0'){
            swapcount+=i-last;
                last++;
            }

            
        }
        return swapcount;
    }
}