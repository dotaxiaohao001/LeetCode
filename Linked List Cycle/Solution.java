/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
       	if(head == null) return false;
       	ListNode p, q;
       	p = head.next;
       	if(p != null)
       	q = p.next;
       	while(p != null && q != null){
       		if(p == q)
       			return true;
       		else{
       			p = p.next;
       			if(p != null)
       			q = q.next.next;
       		}
       	}

       	return false;
    }
// better code
        public boolean hasCycle1(ListNode head) {
        ListNode fast, slow;
        fast = head; 
        slow = head;
        while(fast != null && fast.next != null){
          fast = fast.next.next;
          slow = slow.next;
          if(fast == slow)
            return true;
        }
        return false;
    }
}