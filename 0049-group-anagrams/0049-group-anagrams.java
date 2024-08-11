class Solution {
    private String getFrequencyString(String str){
        int[] freq=new int[26];
        for(char c: str.toCharArray()){
            freq[c-'a']++;
        }
        StringBuilder frequencyString=new StringBuilder("");
        char c='a';
        for(int i: freq){
            frequencyString.append(c);
            frequencyString.append(i);
            c++;
            
        }
        return frequencyString.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        // check for empty inputs
        if(strs==null || strs.length==0){
            return new ArrayList<>();
        }
        
        Map<String,List<String>> frequencyStringmap=new HashMap<>();
        for(String str:strs){
            String frequencyString= getFrequencyString(str);
            
            // if frequency string is present ,add the string to the list
            
            if(frequencyStringmap.containsKey(frequencyString)){
                frequencyStringmap.get(frequencyString).add(str);
            }
            else{
                List<String> strList=new ArrayList<>();
                strList.add(str);
                frequencyStringmap.put(frequencyString,strList);
            }
        }
        return new ArrayList<>(frequencyStringmap.values());
    }
}