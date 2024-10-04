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
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode res=new ListNode(0);
        ListNode p=res;
      PriorityQueue<ListNode> pq=new PriorityQueue<>((x,y)->x.val-y.val);
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
             pq.offer(lists[i]);   
            }
        }
        while(!pq.isEmpty()){
            ListNode node=pq.poll();
            if(node.next!=null) pq.add(node.next);
            p.next=node;
            p=p.next;
        }
        return res.next;
    }
}