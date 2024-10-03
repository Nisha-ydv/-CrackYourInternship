

 class Solution{
    public int minSubarray(int[] nums, int p) {
        int totalSum = 0;
        // Calculate the total sum of the array
        for (int num : nums) {
            totalSum = (totalSum + num) % p;
        }

        // If the total sum is already divisible by p, return 0
        if (totalSum == 0) {
            return 0;
        }

        // Use a hashmap to store the prefix sum modulo p and its index
        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, -1);  // Initialize the map for prefix sum 0
        int prefixSum = 0;
        int minLength = nums.length;

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            prefixSum = (prefixSum + nums[i]) % p;
            // Calculate the remainder we need to find
            int target = (prefixSum - totalSum + p) % p;

            // If the target exists in the prefixMap, update minLength
            if (prefixMap.containsKey(target)) {
                minLength = Math.min(minLength, i - prefixMap.get(target));
            }

            // Update the prefixMap with the current prefix sum and its index
            prefixMap.put(prefixSum, i);
        }

        // Return the result, or -1 if no valid subarray was found
        return minLength == nums.length ? -1 : minLength;
    }

   
}
