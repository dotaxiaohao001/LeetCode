/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
    	if(head == null) return head;
    	ListNode mhead = new ListNode(0);
    	mhead.next = head;

    	ListNode pre, first, second;
    	pre = mhead;
    	first = head;
    	second = head.next;
    	while(first != null && second != null){
    		first.next = second.next;
    		second.next = first;
    		pre.next = second;

    		pre = first;
    		first = first.next;// equal to pre.next.next.next
    		if(first != null)
    			second = first.next;

    	}

    	return mhead.next;

        
    }
}