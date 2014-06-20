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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode mhead = new ListNode(head.val + 1);// sorted 
        mhead.next = head;
        ListNode pre = mhead;
        ListNode first = head;
        ListNode second = head.next;
        while(second != null){
        	while(second != null && first.val == second.val){
        		first = first.next;
        		second = second.next;
        	}
        	if(pre.next == first){// attention not compare value but the original objects
        		pre = pre.next;
        	}else{// if first pointer has moved it means duplicates
        		pre.next = second;
        	}
        	if(second != null){
        	    first = first.next;
        	    second = second.next;
        	}
        }
        return mhead.next;
    }
}