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
// class Solution {
//     public TreeNode replaceValueInTree(TreeNode root) {
//       Queue<TreeNode> q=new LinkedList<>();
//         q.offer(root);
//         int prevSum=root.val;
//         int currsum=0;
//         while(!q.isEmpty()){
//             int size=q.size();
//             for(int i=0;i<size;i++){
                
//                 TreeNode node=q.poll();
//                 node.val=prevSum-node.val;
//                 int sibsum=0;
//                 if(node.left!=null){
//                     sibsum+=node.left.val;
//                 }
//                 if(node.right!=null){
//                     sibsum+=node.right.val;
//                 }
//                 if(node.left!=null){
//                     currsum+=node.left.val;
//                     node.left.val=sibsum;
//                     q.offer(node.left);
//                 }
//                 if(node.right!=null){
//                     currsum+=node.right.val;
//                     node.right.val=sibsum;
//                     q.offer(node.right);
//                 }
//             }
//             prevSum=currsum;
//         }
//         return root;
        
//     }
// }

class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        root.val = 0;  // As root has no cousins, set its value to 0.

        while (!q.isEmpty()) {
            int size = q.size();
            int levelSum = 0;  // Sum of all nodes at the current level.
            List<TreeNode> nodesAtLevel = new ArrayList<>();  // To hold the nodes at the current level.

            // First pass to calculate the total sum of the level.
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                nodesAtLevel.add(node);  // Keep track of all nodes at this level.
                if (node.left != null) {
                    levelSum += node.left.val;
                    q.offer(node.left);
                }
                if (node.right != null) {
                    levelSum += node.right.val;
                    q.offer(node.right);
                }
            }

            // Second pass to update each node's children based on the cousin sum.
            for (TreeNode node : nodesAtLevel) {
                int siblingSum = 0;
                if (node.left != null) siblingSum += node.left.val;
                if (node.right != null) siblingSum += node.right.val;

                // Now update the left and right children to cousin sums.
                if (node.left != null) {
                    node.left.val = levelSum - siblingSum;  // Cousin sum for left child.
                }
                if (node.right != null) {
                    node.right.val = levelSum - siblingSum;  // Cousin sum for right child.
                }
            }
        }

        return root;
    }
}
