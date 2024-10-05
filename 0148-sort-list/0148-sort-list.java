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
// class Solution {
      
//     public ListNode merge(ListNode list1, ListNode list2) {
//       ListNode  dummy=new ListNode (-1);
//         ListNode  crr=dummy;
       
//         while(list1!=null&&list2!=null){
//             if(list1.val<=list2.val){
//                 crr.next=new ListNode (list1.val);
//                 list1=list1.next;
//             }
//              else{
//                 crr.next=new ListNode (list2.val);
//                 list2=list2.next;
//              }
//               crr=crr.next;
//         }
        
//           while(list1!=null){
//             crr.next= new ListNode(list1.val);
//             list1=list1.next;
//           }
//            while(list2!=null){
//             crr.next= new ListNode(list2.val);
//             list2=list2.next;
//           }
          

//          return dummy.next;
//     }


//     public ListNode mergesort(ListNode head){
//         if(head==null && head.next==null) return head;
//         ListNode slow=head;
//         ListNode fast=head;
//         // ListNode prev=null;
//         while(fast!=null && fast.next!=null){
//             // prev=slow;
//             slow=slow.next;
//             fast=fast.next.next;
//         }
//         // prev.next=null;
//          ListNode head2= mergesort(slow.next);
//         slow.next=null;
//         ListNode head1=mergesort(head);
       
        
//         ListNode ans=merge(head1,head2);
//         return ans;
//     }
//     public ListNode sortList(ListNode head) {
//        return mergesort(head);
        
//     }
// }






class Solution{
 public ListNode mergeTwoSortedLinkedLists(ListNode list1, ListNode list2) {
    
    ListNode dummyNode = new ListNode(-1);
    ListNode temp = dummyNode;

    
    while (list1 != null && list2 != null) {
        
        if (list1.val <= list2.val) {
            temp.next = list1;
            list1 = list1.next;
        } else {
            temp.next = list2;
            list2 = list2.next;
        }
        
        temp = temp.next; 
    }
   if (list1 != null) {
        temp.next = list1;
    } else {
        temp.next = list2;
    }
    
    return dummyNode.next;
}


 public ListNode findMiddle(ListNode head){
    if (head == null || head.next == null) {
        return head;
    }

   
    ListNode slow = head;
    ListNode fast = head.next;

    
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    
    
    return slow;
}


public ListNode sortList(ListNode head){
   
    if (head == null || head.next == null) {
        return head;
    }
    
    
    ListNode middle = findMiddle(head);
    
    
    ListNode right = middle.next;
    middle.next = null;
    ListNode left = head;
    
    
    left = sortList(left);
    right = sortList(right);
    
    
    return mergeTwoSortedLinkedLists(left, right);
}
}




