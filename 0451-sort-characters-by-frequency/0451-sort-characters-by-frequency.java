class Solution {
    public class Element implements Comparable<Element>{
        char ch;
        int freq;
        public Element(char ch, int freq){
            this.ch=ch;
            this.freq=freq;
        }
        public int compareTo(Element e2){
            return e2.freq-this.freq;
        }
        
    }
    public String frequencySort(String s) {
        HashMap<Character, Integer> freqMap=new HashMap<>();
        for(char ch : s.toCharArray()){
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Element> q=new PriorityQueue<>();
        for(Map.Entry <Character, Integer> entry: freqMap.entrySet()){
            Element element= new Element(entry.getKey(),entry.getValue());
            q.offer(element);
        }
        StringBuilder str= new StringBuilder();
        while(q.size()>0){
            Element element= q.poll();
            while(element.freq>0){
                str.append(element.ch);
                element.freq--;
            }
        }
        return str.toString();
        
    }
}