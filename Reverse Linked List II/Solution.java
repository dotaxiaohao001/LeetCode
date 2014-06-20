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
	    public ListNode reverseBetween(ListNode head, int m, int n) {
	    	ListNode pre = null, cur = null, after = null;
	    	if(head != null){
	    		pre = null;
	    		cur = head;
	    		after = head.next;
	    	}
	    	//find the range to reverse
	    	int i = 1;
	    	for(; i < m; ++i){
	    		pre = cur;
	    		cur = after;
	    		after = cur.next;
	    	}
	    	ListNode ltail = pre;
	    	ListNode subhead, subtail;
	    	subtail = cur;
	    	if(i < n){
	    	pre = cur;
	    	cur = after;
	    	after = cur.next;
	    	i++;
	    	}
	    	for(; i < n; ++i){
	    		cur.next = pre;

	    		pre = cur;
	    		cur = after;
	    		after = cur.next;
	    	}

	    	cur.next = pre;
	    	subhead = cur;
	    	if(ltail != null)
	    		ltail.next = cur;
	    	else
	    		head = subhead;
	    	subtail.next = after;

	    	return head;
	    }
}