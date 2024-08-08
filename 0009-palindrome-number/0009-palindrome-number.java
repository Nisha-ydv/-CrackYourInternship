class Solution {
    public int reverse(int x){
     int rev=0;
        while(x>0){
          rev=rev*10 +x%10;
          x=x/10;
        }  
        return rev;
    }
    public boolean isPalindrome(int x) {
        int b= reverse(x);
        if(b==x){
            return true;
        }
        else{
        return false;
        }
    }
}