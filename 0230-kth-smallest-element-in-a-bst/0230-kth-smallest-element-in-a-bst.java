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
    int pos=0;
    public TreeNode inOrder(TreeNode root,int k){
        if(root==null) return root;
        TreeNode left=inOrder(root.left,k);
        if(left!=null){
            return left;
        }
        pos++;
        if(pos==k) return root;
        return inOrder(root.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        TreeNode node=inOrder(root,k);
        if(node==null) return -1;
        return node.val;
        
    }
}