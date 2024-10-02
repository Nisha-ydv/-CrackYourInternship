//class Solution {
    // public int[] arrayRankTransform(int[] arr) {
    //     HashMap<Integer,Integer> map=new HashMap<>();
    //     TreeSet<Integer> set=new TreeSet<>();
    //     for(int num: arr){
    //         set.add(num);
    //     }
    //     int rank=1;
    //     for(int num: set){
    //         map.put(num,rank);
    //         rank++;
    //     }
    //     for(int i=0;i<arr.length;i++){
    //         arr[i]=map.get(arr[i]);
    //     }
    //     return arr;
    
    
    
    
//     public int[] arrayRankTransform(int[] arr) {
//         int n=arr.length;
//         PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
//             public int compare(int x[],int[] y){
//                 return x[0]-y[0];
//             }
//         });
        
//         for(int i=0;i<n;i++){
//           pq.add(new int[]{arr[i],i});  
//         }
        
//         int rank=0;
//         while(!pq.isEmpty()){
//             int prev=Integer.MAX_VALUE;
//             int[] curr= pq.poll();
//             if(prev!=curr[0]){
//                 rank++;
//             }
//             arr[curr[1]]=rank;
//         }
//         return arr;
//     }
// }
    
    
    class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        //(element, index)
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int x[], int y[]){
                return x[0] - y[0]; //cust comp, inc sort
            }
        });
        for(int i=0;i<n;i++){
            pq.offer(new int[]{arr[i],i});
        }
       
        int rank=0;
        int prev=Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            int cur[] = pq.poll();
            if(prev!=cur[0]){
                prev = cur[0];
                rank++;
            }
            arr[cur[1]] = rank;
        }
        return arr;
    }
}