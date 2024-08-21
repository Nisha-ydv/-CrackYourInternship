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
    private class pair{
        int idx;
        TreeNode node;
        pair(int idx,TreeNode node){
            this.idx=idx;
            this.node=node;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
      Queue<pair> q=new LinkedList<pair>();
        pair temp;
        int width=0 ,begin,end,size;
        q.add(new pair(0,root));
        while(!q.isEmpty()){
            size=q.size();
            temp=q.poll();
            begin=temp.idx;
            end=temp.idx;
            if(temp.node.left!=null){
                q.add(new pair(2*end,temp.node.left));
            }
            if(temp.node.right!=null){
                q.add(new pair((2*end)+1,temp.node.right));
            }
            for(int i=2;i<=size;i++){
                temp=q.poll();
                end=temp.idx;
                if(temp.node.left!=null){
                   q.add(new pair(2*end,temp.node.left)); 
                }
                if(temp.node.right!=null){
                q.add(new pair((2*end)+1,temp.node.right));
                }
            }
            if(end-begin+1 >width){
                width=end-begin+1;
            }
        }
        return width;
        
    }
}