class MyCalendar {
    TreeMap<Integer,Integer> map;
    int minmeeting;
    public MyCalendar() {
        map=new TreeMap<>();
         minmeeting=1; 
    }
    
    public boolean book(int start, int end) {
      map.put(start,map.getOrDefault(start,0)+1);
         map.put(end,map.getOrDefault(end,0)-1);
        int numbooking=0;
        for(Integer key:map.keySet()){
            numbooking+=map.get(key);
            if(numbooking>minmeeting){
                map.put(start,map.get(start)-1);
                map.put(end,map.get(end)+1);
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */