class Solution {
    public int rev(int x){
       int res=0;
        int rem=0;
        while(x>0){
            rem=x%10;
            if(res>Integer.MAX_VALUE/10 || res<Integer.MIN_VALUE/10) return 0;
            res=(res*10)+rem;
            x/=10;
        }
        return res;  
    }
    public int reverse(int x) {
        
        if(x<0){
            x=-x;
            int res=rev(x);
            return -res;
        }
        else{
            int res=rev(x);
            return res;
        }
        
     
    }
}