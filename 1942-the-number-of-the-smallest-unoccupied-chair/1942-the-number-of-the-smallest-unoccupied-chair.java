class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
      int targetArrival=times[targetFriend][0];
        Arrays.sort(times,new Comparator<int[]>(){
            public int compare(int a[],int b[]){
              return a[0]-b[0];  
            }
            
        });
        
        //leaving time,chairno
        PriorityQueue<int[]> occupied=new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int a[],int b[]){
                return a[0]-b[0];
            }
        });
        
        PriorityQueue<Integer> available=new PriorityQueue<>();
        int chairno=0;
        
        for(int time[]:times){
            int arrtime=time[0];
            int leavingtime=time[1];
            while(!occupied.isEmpty() && occupied.peek()[0]<= arrtime){
                available.offer(occupied.poll()[1]);
        }
            int currentchairno;
            if(available.isEmpty()){
                currentchairno=chairno;
                chairno++;
            }
            else{
                currentchairno=available.poll();
            }
            if(targetArrival==arrtime) return currentchairno;
            occupied.offer(new int[]{leavingtime,currentchairno});
            
    }
        return -1;
}
}