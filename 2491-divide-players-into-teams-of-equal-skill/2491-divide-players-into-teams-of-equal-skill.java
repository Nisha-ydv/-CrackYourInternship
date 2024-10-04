// class Solution {
    
//     public long dividePlayers(int[] skill) {
        
//         int sum=0;
//         int n=skill.length;
//         int team=n/2;
        
//         int reqsum=sum/team;;
        
//      HashMap<Integer,Integer> map=new HashMap<>();
        
//         for(int element:skill){
//             sum+=element;
//             map.put(element,map.getOrDefault(element,0)+1);
//         }
//           if(sum%team !=0) return -1;
//           long ans=0;
//         for(int element:skill){
//             if(map.get(element)==0){
//                 continue;
//             }
//             map.put(element,map.get(element)-1);
//           int partner=reqsum-element;
            
//             if(!map.containsKey(partner) || map.get(partner)==0){
//                 return -1;
//             }
//             map.put(element,map.get(element)-1);
//             ans+=(long)element*(long)partner;
//             }
//         return ans;
//     }
// }


// class Solution {
//     public long dividePlayers(int[] skill) {
//         int n = skill.length;
//         int teams = n/2;
//         int totalSum=0;
//         HashMap<Integer,Integer> freqMap = new HashMap<>();
//         for(int element : skill){
//             freqMap.put(element, freqMap.getOrDefault(element,0)+1);
//             totalSum += element;
//         }
//         if(totalSum % teams !=0 ){
//             return -1;
//         }
//         int targetPoints = totalSum / teams;
//         long res = 0;
//         for(int element : skill){
//             if(freqMap.get(element)==0){
//                 continue;
//             }
//             freqMap.put(element, freqMap.get(element)-1);
//             int partner = targetPoints - element;
//             if(!freqMap.containsKey(partner) || freqMap.get(partner)==0){
//                 return -1;
//             }
//             freqMap.put(partner, freqMap.get(partner)-1);
//             res = res + ((long)element * (long)partner);
//         }
//         return res;
//     }
// }





class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int teams = n/2;
        int totalSum=0;
        int[] map=new int[1001];
        for(int element : skill){
            map[element]++;
            totalSum += element;
        }
        if(totalSum % teams !=0 ){
            return -1;
        }
        int targetPoints = totalSum / teams;
        long res = 0;
        for(int element : skill){
            if(map[element]==0){
                continue;
            }
            map[element]--;
            int partner = targetPoints - element;
            if(  map[partner]==0){
                return -1;
            }
            map[partner]--;
            res = res + ((long)element * (long)partner);
        }
        return res;
    }
}