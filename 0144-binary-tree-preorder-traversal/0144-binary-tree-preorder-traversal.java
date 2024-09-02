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
    public void preorder(List<Integer> list,TreeNode root){
        if(root==null) return ;
        list.add(root.val);
        if(root.left!=null) preorder(list,root.left);
        if(root.right!=null)  preorder(list, root.right);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new LinkedList<>();
        if(root==null) return list;
        preorder(list, root);
        return list;
        
    }
}