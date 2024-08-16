/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() ;
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     
    public void helper(TreeNode root,List<Integer> list ){
        if(root==null) return ;
        helper(root.left,list);
        list.add(root.val);
        helper(root.right,list);
    }
    public boolean isValidBST(TreeNode root) {
        List<Integer> list=new LinkedList<>();
        helper(root,list);
        boolean isBST=true;
        int prev=list.get(0);
        for(int i=1;i<list.size();i++){
            if(list.get(i)<=prev)
                isBST=false;
                prev=list.get(i);
        }
        return isBST;
        
        
    }
}

// class Solution {

//  public boolean checkBST(TreeNode root) {

//     List<Integer> inOrderList = new LinkedList<>();

//     // Populate the list
//     helper(root, inOrderList);

//     boolean isBST = true;
//     int prev = inOrderList.get(0);
//     for (int i = 1; i < inOrderList.size(); i++) {

//       // Check if new element is smaller than previous element
//       // or if the element is duplicate
//       if (inOrderList.get(i) <= prev)
//         isBST = false;

//       prev = inOrderList.get(i);
//     }

//     return isBST;
//   }

//  public void helper(TreeNode treeNode, List<Integer> inOrderList) {
//     if (treeNode == null)
//       return;

//     helper(treeNode.left, inOrderList);
//     inOrderList.add(treeNode.val);
//     helper(treeNode.right, inOrderList);
//   }

// }