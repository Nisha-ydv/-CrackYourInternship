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
    private ListNode middleNode(ListNode head, ListNode tail){
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        if(prev!=null)
            prev.next=null;
        
        return slow;
    }
    public TreeNode sortedListToBST(ListNode head) {
      if(head==null) return null;
        ListNode middle=middleNode(head,null);
        TreeNode root=new TreeNode(middle.val);
        if(middle==head) return root;
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(middle.next);
        return root;
    }
}