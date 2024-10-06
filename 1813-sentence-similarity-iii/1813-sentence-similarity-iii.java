class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
       if(sentence1.length()>sentence2.length()){
           return areSentencesSimilar( sentence2, sentence1);
       }
        String[] smallerWord=sentence1.split(" ");
        String[] largerWord=sentence2.split(" ");
        int start=0;
        int end1=smallerWord.length-1;
        int end2=largerWord.length-1;
        
        while(start<=end1 && smallerWord[start].equals(largerWord[start])){
            start++;
        }
        while(start<=end1 && smallerWord[end1].equals(largerWord[end2])){
            end1--;
            end2--;
        }
        return (start>end1);
        
        
    }
}