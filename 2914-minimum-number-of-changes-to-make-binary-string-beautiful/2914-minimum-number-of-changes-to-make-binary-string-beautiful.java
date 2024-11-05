// class Solution {
//     public int minChanges(String s) {
        
//     }
// }

class Solution {
    public int minChanges(String s) {
        List<Integer> odd = new ArrayList<>();
        int n = s.length();
        
        int i = 1;
        int start = 0;
        int count = 0;
        while (i < n) {
            while (i < n && s.charAt(i) == s.charAt(i - 1)) {
                i++;
            }
            
            if ((i - start) % 2 == 1) {
                odd.add(count);
            }
            
            count++;
            start = i;
            i++;
        }
        
        if ((i - start) % 2 == 1) {
            odd.add(count);
        }

        int minChanges = 0;
        for (int pos = 1; pos < odd.size(); pos += 2) {
            minChanges += odd.get(pos) - odd.get(pos - 1);
        }
        
        return minChanges;
    }
}