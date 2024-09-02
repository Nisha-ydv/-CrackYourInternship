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
    int sum=0;
    
    public int sumNumbers(TreeNode root) {
        getLeafSum(root,0);
        return sum;
    }
    public void getLeafSum(TreeNode root, int currNum){
        if(root==null){
            return;
        }
        currNum=currNum*10+root.val;
        if(root.left== null && root.right==null){
            sum+=currNum;
            return;
        }
        getLeafSum(root.left, currNum);
        getLeafSum(root.right,currNum);
    }
}