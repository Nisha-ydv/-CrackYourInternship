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
//     private TreeNode first;
//     private TreeNode prev;
//     private TreeNode middle;

//     private void inorder(TreeNode root){
//         if(root==null) return;
//         inorder(root.left);
//         if(root.val<prev.val){
//             if(first==null) {
//                 first=prev;
//                 middle=root;
//             }
//             else{
//                 middle=root;
//             }
//             prev=root;
//             inorder(root.right);
//         }
//     }
//     public void recoverTree(TreeNode root) {
//        first=middle=null;
//         prev=new TreeNode(Integer.MIN_VALUE);
//         inorder(root);
//         if(first!=null && middle!=null){
//             int temp=first.val;
//             first.val=middle.val;
//             middle.val=temp;
//         }
        
//     }
// }

class Solution {
    TreeNode prev;
    TreeNode violation1;
    TreeNode violation2;
	
    public void inorder(TreeNode root) {
        if(root == null)
            return;
        
        inorder(root.left);
        
        if(prev != null && prev.val > root.val)
 {

                if(violation1 == null)
                    violation1 = prev;
                violation2 = root;
        }
        
        prev = root;
        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        inorder(root);
        
        int temp = violation1.val;
        
        violation1.val = violation2.val;
        violation2.val = temp;
    }
}