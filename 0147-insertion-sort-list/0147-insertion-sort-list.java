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
    public ListNode insertionSortList(ListNode head) {
      if(head==null || head.next==null){
          return head;
      } 
        ListNode temp=head.next;
        ListNode sortedtail=head;
        while(temp!=null){
            if(temp.val>=sortedtail.val){
                sortedtail=temp;
                temp=temp.next;
                continue;
            }
            sortedtail.next=temp.next;
            ListNode prev=null;
            ListNode t1=head;;
            while(t1!=sortedtail.next){
                if(t1.val>temp.val){
                    break;
                }
                prev=t1;
                t1=t1.next;
            }
            // insert at head
            if(prev==null){
             temp.next=head;
                head=temp;
            }else{
                // insert at specific position
               temp.next=prev.next;
                prev.next=temp;
            }
            temp=sortedtail.next;
        }
        return head;
    }
}