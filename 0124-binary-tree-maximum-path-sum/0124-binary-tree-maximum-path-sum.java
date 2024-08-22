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
    int maxPath_sum_util(TreeNode root,int maxi[]){
        if(root==null) return 0;
        int left= Math.max(0,maxPath_sum_util(root.left,maxi));
        int right= Math.max(0,maxPath_sum_util(root.right,maxi));
        maxi[0]=Math.max(maxi[0],left+right+root.val);
        return Math.max(left,right)+root.val;
        
    }
    public int maxPathSum(TreeNode root) {
        
        int maxvalue[]=new int[1];
        
        maxvalue[0]=Integer.MIN_VALUE;
        maxPath_sum_util(root,maxvalue);
        return maxvalue[0];
    }
}