class Solution {
    public long pickGifts(int[] gifts, int k) {
        int n=gifts.length;
       
        
        while(k>0){
             int max=0;
            int index=-1;
          for(int i=0;i<n;i++){
           if(gifts[i]>max){
               max=gifts[i];
               index=i;
           }
            
        }
        gifts[index]=(int)Math.sqrt(gifts[index]);
            k--;
          
        }
        long sum=0;
        for(int i=0;i<n;i++){
           sum+=gifts[i]; 
        }
        return sum;
        
    }
}