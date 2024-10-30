// class Solution {
//     public int minimumMountainRemovals(int[] nums) {
        
//     }
// }

class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        
        // Edge case: if nums has fewer than 3 elements, it can't be a mountain array.
        if (n < 3) return 0;

        // Step 1: Compute LIS up to each index
        int[] LIS = new int[n];
        for (int i = 0; i < n; i++) {
            LIS[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
        }

        // Step 2: Compute LDS from each index
        int[] LDS = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            LDS[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    LDS[i] = Math.max(LDS[i], LDS[j] + 1);
                }
            }
        }

        // Step 3: Calculate the longest mountain sequence length
        int maxMountainLen = 0;
        for (int i = 1; i < n - 1; i++) { // `i` must be a valid peak
            if (LIS[i] > 1 && LDS[i] > 1) { // Check if `i` can be a peak
                maxMountainLen = Math.max(maxMountainLen, LIS[i] + LDS[i] - 1);
            }
        }

        // Step 4: Minimum removals to make the mountain array
        return n - maxMountainLen;
    }
}
