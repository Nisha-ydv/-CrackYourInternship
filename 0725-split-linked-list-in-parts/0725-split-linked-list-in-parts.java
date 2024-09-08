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
    public ListNode[] splitListToParts(ListNode head, int k) {
      ListNode temp=head;
        int size=0;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        ListNode res[]=new ListNode[k];
        temp=head;
        int average=size/k;
        int extra=size%k;
        for(int i=0;i<k;i++){
            if(temp==null) break;
            ListNode currhead=temp;
            ListNode prev=null;
            int length=0;
            while(temp!=null && length<average){
                prev=temp;
                temp=temp.next;
                length++;
            }
            if(extra>0){
                prev=temp;
                temp=temp.next;
                extra--;
            }
            prev.next=null;
            res[i]=currhead;
        }
        return res;
    }
}