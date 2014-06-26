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
    public void reorderList(ListNode head) {

    	if(head == null) return ;

        //find the middle position
        ListNode fast, slow, mid, tail;
        fast = head;
        slow = head;
        mid = null;
        while(fast != null){
        	mid = slow;
        	fast = fast.next;
        	if(fast != null)
        		fast = fast.next;
        	slow = slow.next;
        }
        mid.next = null;
        tail = head;
        ListNode l1 = head.next;
        // reverse the second part use the mid pointer as the prev 
        ListNode l2 = reverseList(slow);

        //merge 2 list
        while(l1 != null && l2 != null){
        	tail.next = l2;
        	l2 = l2.next;
        	tail = tail.next;

        	tail.next = l1;
        	l1 = l1.next;
        	tail = tail.next;
        }

        if(l1 != null)
        	tail.next = l1;
        if(l2 != null)
        	tail.next = l2;
    }

    public ListNode reverseList(ListNode head) {
    	if(head == null)
    		return null;
    	ListNode mhead = new ListNode (head.val);
    	mhead.next = head;
    	ListNode pre = mhead;
    	ListNode first = head; // point the tail of reversed lisd
    	ListNode second = head.next;// the one need to insert at the head place
    	while(second != null){
    		first.next = second.next;
    		second.next = pre.next;//figure out what is the fist second !!
    		pre.next = second;
    		
    		second = first.next;
    		//first = pre.next; first never change
    	}
    	return mhead.next;
    }
}