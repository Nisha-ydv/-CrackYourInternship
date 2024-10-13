class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
      PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
        public int compare(int a[],int b[]){
            return a[0]-b[0];
        }  
      }); 
        int k=nums.size();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            int minval=nums.get(i).get(0);
            pq.offer(new int[]{minval,i,0});
            max=Math.max(max,minval);
        }
        int[] minrange={0,Integer.MAX_VALUE};
        while(true){
            int top[]=pq.poll();
            int minElement=top[0],listIndex=top[1],elementIndex=top[2];
            if(max-minElement<minrange[1]-minrange[0]){
                minrange[0]=minElement;
                minrange[1]=max;
            }
            if(elementIndex==nums.get(listIndex).size()-1) break;
            int next=nums.get(listIndex).get(elementIndex+1);
            max=Math.max(max,next);
            pq.offer(new int[]{next,listIndex,elementIndex+1});
        }
        return minrange;
    }
}