// class Solution {
    
//     public long dividePlayers(int[] skill) {
//         long ans=0;
//         int sum=0;
//         int n=skill.length;
//         int team=n/2;
        
//         int reqsum=sum/team;;
//         if(sum%team !=0) return -1;
//      HashMap<Integer,Integer> map=new HashMap<>();
        
//         for(int i=0;i<skill.length;i++){
//             sum+=skill[i];
//             map.put(skill[i],map.getOrDefault(skill[i],0)+1);
//         }
        
//         for(int i=0;i<skill.length;i++){
//             if(map.get(skill[i])==0){
//                 continue;
//             }
//             map.put(skill[i],map.get(skill[i])-1);
//           int partner=reqsum-skill[i];
            
//             if(!map.containsKey(partner) || map.get(partner)==0){
//                 return -1;
//             }
//             ans+=(long)skill[i]*(long)partner;
//             int currfreq=map.get(partner);
//             map.put(skill[i],currfreq-1);
//         }
//         return ans;
//     }
// }


class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int teams = n/2;
        int totalSum=0;
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        for(int element : skill){
            freqMap.put(element, freqMap.getOrDefault(element,0)+1);
            totalSum += element;
        }
        if(totalSum % teams !=0 ){
            return -1;
        }
        int targetPoints = totalSum / teams;
        long res = 0;
        for(int element : skill){
            if(freqMap.get(element)==0){
                continue;
            }
            freqMap.put(element, freqMap.get(element)-1);
            int partner = targetPoints - element;
            if(!freqMap.containsKey(partner) || freqMap.get(partner)==0){
                return -1;
            }
            freqMap.put(partner, freqMap.get(partner)-1);
            res = res + ((long)element * (long)partner);
        }
        return res;
    }
}