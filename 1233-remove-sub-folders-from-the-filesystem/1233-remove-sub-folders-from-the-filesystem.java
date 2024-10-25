// class Solution {
//     public List<String> removeSubfolders(String[] folder) {
        
//     }
// }



class Solution {
    public List<String> removeSubfolders(String[] folder) {
        // Step 1: Sort the folders lexicographically
        Arrays.sort(folder);
        
        // Step 2: Initialize the result list
        List<String> result = new ArrayList<>();
        
        // Step 3: Iterate through the sorted list of folders
        for (String f : folder) {
            // Check if the current folder is a sub-folder of the last folder in result
            if (result.isEmpty() || !f.startsWith(result.get(result.size() - 1) + "/")) {
                result.add(f);  // Add the folder if it is not a sub-folder
            }
        }
        
        return result;
    }
}
