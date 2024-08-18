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
    
    private TreeNode splitTree(int[] preOrder,Map<Integer,Integer>inOrderMap,int rootIndex,int left, int right){
        TreeNode root=new TreeNode(preOrder[rootIndex]);
        //create left and right subtree
        int mid=inOrderMap.get(preOrder[rootIndex]);
        if(mid>left) 
            root.left=splitTree(preOrder,inOrderMap,rootIndex+1,left,mid-1);
        if(mid<right)
            root.right=splitTree(preOrder,inOrderMap,rootIndex +mid-left+1,mid+1,right);
        return root;
    }
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        Map<Integer,Integer> inOrderindexMap=new HashMap<>();
        for(int i=0;i<inOrder.length;i++){
            inOrderindexMap.put(inOrder[i],i);
            
        }
        return splitTree(preOrder,inOrderindexMap,0,0,inOrder.length-1);
    }
}