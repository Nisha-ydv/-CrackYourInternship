class Solution {
    public int sum(int n){
        int sum=0;
        int rem=0;
        while(n>0){
          rem=n%10;
        sum+=rem;
        n/=10;   
        }
        
        return sum;
    }
    public int addDigits(int num) {
       int res=sum(num);
        while(res>9){
            res=sum(res);
        }
        return res;
    }
}