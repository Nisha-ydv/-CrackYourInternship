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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> q=new ArrayDeque<>();
        boolean flag=false;
        if(root==null) return ans;
        q.add(root);
        while(!q.isEmpty()){
            int qsize=q.size();
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<qsize;i++){
                if(q.peek().left!=null) q.add(q.peek().left);
                if(q.peek().right!=null) q.add(q.peek().right);
                temp.add(q.poll().val);
            }
            flag=!flag;
            if(!flag) Collections.reverse(temp);
            ans.add(temp);
        }
        return ans;
    }
}