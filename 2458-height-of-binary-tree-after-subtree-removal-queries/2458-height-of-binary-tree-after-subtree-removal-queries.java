/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// class Solution {
//     public int[] treeQueries(TreeNode root, int[] queries) {
        
//     }
// }

class Solution {
    private int[] level = new int[1000001]; // Level of each node
    private int[] height = new int[100001]; // Height of each node
    private int[] levelMaxHt = new int[100001];
    private int[] levelSecondMaxHt = new int[100001];

    // Method to find the height of each node and populate the max heights at each level
    private int findHeight(TreeNode root, int l) {
        if (root == null) {
            return 0;
        }

        level[root.val] = l;
        height[root.val] = Math.max(findHeight(root.left, l + 1), findHeight(root.right, l + 1)) + 1;

        if (levelMaxHt[l] < height[root.val]) {
            levelSecondMaxHt[l] = levelMaxHt[l];
            levelMaxHt[l] = height[root.val];
        } else if (levelSecondMaxHt[l] < height[root.val]) {
            levelSecondMaxHt[l] = height[root.val];
        }

        return height[root.val];
    }

    // Main method to process queries
    public int[] treeQueries(TreeNode root, int[] queries) {
        findHeight(root, 0);

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int node = queries[i];
            int L = level[node]; // Node's level

            // Calculate result for this node
            int tempResult = L + (levelMaxHt[L] == height[node] ? levelSecondMaxHt[L] : levelMaxHt[L]) - 1;
            result[i] = tempResult;
        }

        return result;
    }
}