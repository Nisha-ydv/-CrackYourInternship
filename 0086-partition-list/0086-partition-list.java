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
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smaller=new ListNode(0);   // list which all element less than x
        ListNode higher=new ListNode(0);
         
        ListNode smallerhead=smaller;
        ListNode higherhead=higher;
        while(head!=null){
            if(head.val<x){
              smallerhead.next=head;
                smallerhead=smallerhead.next;
            } 
            else{
              higherhead.next=head;
                higherhead=higherhead.next;
            } 
            head=head.next;
            
        }
        higherhead.next=null;
        smallerhead.next=higher.next;
        return smaller.next;
        
    }
}