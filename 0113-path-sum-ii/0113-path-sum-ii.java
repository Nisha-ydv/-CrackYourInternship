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
    
    public void preOrder( List<List<Integer>> paths,List<Integer> path,TreeNode root,int targetSum){
        if(root==null) return ;
        targetSum= targetSum-root.val;
        path.add(root.val);
        if(root.right==null && root.left==null && targetSum==0){
            paths.add( new ArrayList<>(path));
        }
        preOrder(paths, new ArrayList<>(path) ,root.left,targetSum);
        preOrder(paths, new ArrayList<>(path) , root.right,targetSum);
        path.remove(path.size()-1);
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        if(root==null) 
            return paths;
        preOrder(paths,path,root, targetSum);
            return paths;
    }
}