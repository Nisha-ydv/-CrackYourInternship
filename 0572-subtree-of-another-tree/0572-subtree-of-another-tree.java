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
    
//     public String preOrderTraversal(TreeNode root){
//         if(root==null){
//             return "null";
//         }
//         StringBuilder sb=new StringBuilder("");
//         sb.append(root.val);
//         sb.append(preOrderTraversal(root.left));
//         sb.append(preOrderTraversal(root.right));
//         return sb.toString();
//     }
//     public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//         String fullTree=preOrderTraversal(root);
//         String subTree=preOrderTraversal(subRoot);
//         return (fullTree.contains(subTree));
//     }
// }

 class Solution {

  String preOrderTraversal(TreeNode node) {
    if (node == null) {
      return "null";
    }

    StringBuilder sb = new StringBuilder("^");
    sb.append(node.val);
    sb.append(preOrderTraversal(node.left));
    sb.append(preOrderTraversal(node.right));

    return sb.toString();
  }

  boolean isSubtree(TreeNode root, TreeNode subRoot) {

    String fullTree = preOrderTraversal(root);
    String subTree = preOrderTraversal(subRoot);

    return (fullTree.contains(subTree));
  }

}