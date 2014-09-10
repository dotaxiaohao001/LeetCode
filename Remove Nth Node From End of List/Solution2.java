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
/**
*基本一样， use two pointer, one is n+1 ahead of another one, then move with same pace.
**/
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode pre, end;
    	pre = end = dummy;
    	//move end n steps ahead of pre
    	for(int i = 0; i < n; ++i){
    		end = end.next;
    	}
    	//move two ponters at the same pace
    	while(end.next != null) {
    		end = end.next;
    		pre = pre.next;
    	}
    	//skip the pre.next node
    	pre.next = pre.next.next;

    	return dummy.next;
    }
}