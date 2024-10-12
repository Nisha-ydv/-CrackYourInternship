class Solution {
    
     class pair implements Comparable<pair>{
        String video;
        int freq;
     public   pair(String video,int freq){
            this.video=video;
            this.freq=freq;
        }
        public int compareTo(pair that){
            if(this.freq==that.freq){
                return this.video.compareTo(that.video);
            }
            return this.freq-that.freq;
        }
    }
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
      Queue<Integer> q=new LinkedList<>();
        HashSet<Integer> visited=new HashSet<>();
        q.add(id);
        visited.add(id);
        int currlevel=0;
        while(!q.isEmpty()){
            int size=q.size();
            //iterate level by level
            for(int i=0;i<size;i++){
                int currid=q.poll();
                for(int friend:friends[currid]){
                    if(!visited.contains(friend)){
                        visited.add(friend);
                        q.offer(friend);
                    }
                }
            }
            
            currlevel++;
            if(currlevel==level){
                break;
            }
        }
            
            HashMap<String,Integer> freqmap=new HashMap<>();
            while(!q.isEmpty()){
                int currid=q.poll();
                for(String video:watchedVideos.get(currid)){
                    freqmap.put(video,freqmap.getOrDefault(video,0)+1);
                }
            }
            
            List<pair> videoList=new ArrayList<>();
            for(String video:freqmap.keySet()){
                videoList.add(new pair(video,freqmap.get(video)));
            }
            
            Collections.sort(videoList);
            List<String> res=new ArrayList<>();
            for(pair pair:videoList){
                res.add(pair.video);
            }
            
          return res;
        
    }
}