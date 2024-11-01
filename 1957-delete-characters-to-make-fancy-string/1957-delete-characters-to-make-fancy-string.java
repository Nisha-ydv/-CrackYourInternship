// class Solution {
//     public String makeFancyString(String s) {
        
//     }
// }

class Solution {
    public String makeFancyString(String s) {
        // Using a StringBuilder to efficiently build the result string
        StringBuilder result = new StringBuilder();
        
        // Iterate through each character in the input string
        for (int i = 0; i < s.length(); i++) {
            // Get the current character
            char currentChar = s.charAt(i);
            
            // Check if we have two consecutive characters at the end of result
            int len = result.length();
            if (len >= 2 && result.charAt(len - 1) == currentChar && result.charAt(len - 2) == currentChar) {
                // Skip this character to avoid three consecutive identical characters
                continue;
            }
            
            // Append the current character to the result
            result.append(currentChar);
        }
        
        // Convert the StringBuilder to a String and return it
        return result.toString();
    }
}
