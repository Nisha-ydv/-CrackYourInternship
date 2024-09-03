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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> l=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null) return l;
        int max=Integer.MIN_VALUE;
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp!=null){
                if(max<temp.val) max=temp.val;
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }
            else{
                l.add(max);
                max=Integer.MIN_VALUE;
                if(!q.isEmpty()) q.offer(null);
            }
        }
        return l;
    }
}