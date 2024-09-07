class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int boxes=0;
        int applesum=0;
        for(int i=0;i<apple.length;i++){
            applesum+=apple[i];
        }
        Arrays.sort(capacity);
       
        for(int i=capacity.length-1;i>=0;i--){
           if(applesum>0){
              applesum-=capacity[i];
               boxes++;
             } 
           
        }
        return boxes;
    }
}