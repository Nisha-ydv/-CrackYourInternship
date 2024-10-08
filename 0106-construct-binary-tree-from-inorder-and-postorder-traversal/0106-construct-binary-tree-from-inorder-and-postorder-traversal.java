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
    private TreeNode buildTreePost(int[] inorder, int is , int ie, int[] postorder, int ps, int pe, HashMap<Integer, Integer> hm){
        if(ps>pe || is>ie) return null;
        TreeNode root= new TreeNode (postorder[pe]);
        int inRoot =hm.get(postorder[pe]);
        int numleft=inRoot-is;
        root.left=buildTreePost(inorder,is, inRoot-1,postorder,ps,ps+numleft-1,hm);
        root.right=buildTreePost(inorder,inRoot+1, ie,postorder,ps+numleft,pe-1,hm);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || postorder==null ||inorder.length!=postorder.length)
            return null;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
           
        }
         return buildTreePost(inorder,0,inorder.length-1,postorder,0,postorder.length-1,hm);
    }
}