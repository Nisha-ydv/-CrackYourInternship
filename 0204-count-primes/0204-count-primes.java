class Solution {
    public int countPrimes(int n) {
      boolean[] arr=new boolean[n];
       
        Arrays.fill(arr,true);
        int counter=2;
        while(counter<n){
            if(arr[counter]==true){
                for(int factor=counter+counter;factor<n;factor+=counter){
                    arr[factor]=false;
                }
            }
            counter++;
        }
        int res=0;
        for(int i=2;i<n;i++){
            if(arr[i]==true){
                res++;
            }
        }
        return res;
    }
}