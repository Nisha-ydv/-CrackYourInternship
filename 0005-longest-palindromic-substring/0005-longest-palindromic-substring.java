class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<=1){
            return s;
        }
        String LPS="";
        for(int i=1;i<s.length();i++){
            // consider odd length of substring
            int low=i;
            int high=i;
            // keep extending in both direction left and right till the condition of palindrome met
            while(s.charAt(low)==s.charAt(high)){
                low--;
                high++;
                
                // terminating condition if we reach the end/start of the string
                if(low==-1 || high==s.length()){
                    break;
                }
            }
            String palindrome=s.substring(low+1,high);
            if(palindrome.length()>LPS.length()){
                LPS=palindrome;
            }
            
            // consider even length of the palindrome
            low=i-1;
            high=i;
            while(s.charAt(low)==s.charAt(high)){
                low--;
                high++;
                
                if(low==-1 || high==s.length())
                    break;
            }
            
            palindrome=s.substring(low+1,high);
            if(palindrome.length()> LPS.length()){
                LPS=palindrome;
            }
            
        }
        return LPS;
    }
}