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
    public int getSum(TreeNode node,boolean isLeftChild){
        if(node.left==null && node.right==null ){
            return isLeftChild?node.val:0;
        }
        int sum=0;
        if(node.left!=null){
            sum+=getSum(node.left,true);
        }
         if(node.right!=null){
            sum+=getSum(node.right,false);
        }
        return sum;
        
    }
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        return getSum(root,false);
    }
}