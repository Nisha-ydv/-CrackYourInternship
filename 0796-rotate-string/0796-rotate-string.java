class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
        String dobles=s+s;
        return dobles.contains(goal);
        
    }
}

// class Solution {
//     public boolean rotateString(String s, String goal) {
//         // Check if the lengths are different; if so, return false
//         if (s.length() != goal.length()) {
//             return false;
//         }
        
//         // Concatenate s with itself
//         String doubleS = s + s;
        
//         // Check if goal is a substring of the concatenated string
//         return doubleS.contains(goal);
//     }
// }





