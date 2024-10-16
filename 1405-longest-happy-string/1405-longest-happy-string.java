class Solution {
    class pair implements Comparable<pair>{
        int count;
        char ch;
        pair(int count, char ch){
            this.count=count;
            this.ch=ch;
            
        }
        public int compareTo(pair that){
            return that.count-this.count;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
      PriorityQueue<pair> pq=new PriorityQueue<>();
        if(a>0){
            pq.add(new pair(a,'a'));
        }
        if(b>0){
            pq.add(new pair(b,'b'));
        }
        if(c>0){
            pq.add(new pair(c,'c'));
        }
        StringBuilder res=new StringBuilder();
        while(!pq.isEmpty()){
            pair node=pq.poll();
            int n=res.length();
            char ch=node.ch;
            int count=node.count;
            if(n>=2 && res.charAt(n-1)==ch && res.charAt(n-2)==ch){
                if(pq.isEmpty()) break;
                pair sec=pq.poll();
                res.append(sec.ch);
                sec.count--;
                if(sec.count>0){
                    pq.offer(new pair(sec.count,sec.ch));
                }
            }
            else{
                res.append(node.ch);
                node.count--;
            }
            if(node.count>0){
                pq.offer(new pair(node.count,node.ch));
            }
        }
        return res.toString();
    }
}