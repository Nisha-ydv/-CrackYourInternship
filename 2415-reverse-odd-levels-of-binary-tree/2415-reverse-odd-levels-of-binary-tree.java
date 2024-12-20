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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        int level=0;
        q.offer(root);
        
        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<TreeNode> list=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
                if(level%2!=0){
                    list.add(node);
                }
                
            }
            if(level%2!=0){
                int r=0;
                int l=list.size()-1;
                while(r<l){
                    int temp=list.get(r).val;
                    list.get(r).val=list.get(l).val;
                    list.get(l).val=temp;
                    r++;
                    l--;
                }
            }
            level++;
        }
        return root;
    }
}