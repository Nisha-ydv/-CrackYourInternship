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
class Solution {
    private int minDiff=Integer.MAX_VALUE;
    private TreeNode prev=null;
    public int minDiffInBST(TreeNode root) {
        preorder(root);
        return minDiff;
    }
    public void preorder(TreeNode root){
        if(root==null) return;
        preorder(root.left);
        if(prev!=null){
          int diff= Math.abs(prev.val-root.val);
            minDiff= Math.min(diff,minDiff);
        }
        prev=root;
        preorder(root.right);
    }
}