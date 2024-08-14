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
    public void buildpath(TreeNode node,List<String> res,String path){
        if(node.left==null && node.right==null) res.add(path);
        
        if(node.left!=null){
            buildpath(node.left,res,path+"->"+node.left.val);
        }
        if(node.right!=null){
            buildpath(node.right,res,path+"->"+node.right.val);
        }
        
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<>();
        if(root!=null){
            buildpath(root,res,Integer.toString(root.val));
        }
        return res;
    }
}