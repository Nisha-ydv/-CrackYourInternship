/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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

    public TreeNode sortedListToBST(ListNode head){
        List<Integer> list=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }
        return dfs(list,0,list.size()-1);
            
        
    }
    private TreeNode dfs(List<Integer> list,int l, int r){
        if(l>r) return null;
        int mid=l+(r-l)/2;
        TreeNode root=new TreeNode(list.get(mid));
        root.left=dfs(list,l,mid-1);
        root.right=dfs(list,mid+1,r);
        return root;
    }
    
}
//private ListNode middleNode(ListNode head, ListNode tail){
//         ListNode slow=head;
//         ListNode fast=head;
//         ListNode prev=null;
//         while(fast!=null && fast.next!=null){
//             prev=slow;
//             slow=slow.next;
//             fast=fast.next.next;
//         }
//         if(prev!=null)
//             prev.next=null;
        
//         return slow;
//     }
//     public TreeNode sortedListToBST(ListNode head) {
//       if(head==null) return null;
//         ListNode middle=middleNode(head,null);
//         TreeNode root=new TreeNode(middle.val);
//         if(middle==head) return root;
//         root.left=sortedListToBST(head);
//         root.right=sortedListToBST(middle.next);
//         return root;
//     }