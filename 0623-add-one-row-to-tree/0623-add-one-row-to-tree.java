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
    public void dfs(TreeNode root, int currDepth, int depth, int val){
        if(root==null) return ;
        if(currDepth==depth-1){
            TreeNode leftnode=new TreeNode(val);
            leftnode.left=root.left;
            root.left=leftnode;
            
            TreeNode rightnode=new TreeNode(val);
            rightnode.right=root.right;
            root.right=rightnode;
            return ;
        }
        dfs(root.left,currDepth+1,depth,val);
        dfs(root.right,currDepth+1,depth,val);
        }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        TreeNode newNode=null;
      if(depth==1){
        newNode=new TreeNode(val);
          newNode.left=root;
          return newNode;
      }  
        dfs(root,1,depth,val);
        return root;
    }
}