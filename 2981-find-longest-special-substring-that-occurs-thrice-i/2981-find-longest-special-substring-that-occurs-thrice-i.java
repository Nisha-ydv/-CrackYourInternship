class Solution {
    public int maximumLength(String s) {
       HashMap<String, Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            StringBuilder curString=new StringBuilder();
            for(int j=i;j<s.length();j++){
                if(curString.length()==0 || s.charAt(j)==curString.charAt(curString.length()-1)){
                    curString.append(s.charAt(j));
                    String cur= curString.toString();
                    map.put(cur,map.getOrDefault(cur,0)+1);
                }
                else{
                    break;
                }
            }
        }
        
        int maxlength=-1;
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            String str=entry.getKey();
            int freq= entry.getValue();
            if(freq>2){
                maxlength=Math.max(maxlength,str.length());
            }
            
        }
        return maxlength;
    }
}