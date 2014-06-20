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
    public ListNode partition(ListNode head, int x) {
        ListNode l1 = null;
        ListNode l1_tail = l1;
        ListNode l2 = null;
        ListNode l2_tail = l2;

        if(head == null) return head;

        ListNode cur = head;
        while(cur != null){
            ListNode after = cur.next;

        	if(cur.val < x){
        		if(l1 == null){
        			l1 = cur;
        			cur.next = null;// don't forget set next to null
        			l1_tail = l1;
        		}else{
        			l1_tail.next = cur;
        			cur.next = null;
        			l1_tail = l1_tail.next;
        		}
        	}else{
        		if(l2 == null){
        			l2 = cur;
        			cur.next = null;
        			l2_tail = l2; 
        		}else{
        			l2_tail.next = cur;
        			cur.next = null;
        			l2_tail = l2_tail.next;
        		}
        	}
        	// move ahead
        	cur = after;
        }
        if(l1 == null)
        	return l2;
        else{
        	l1_tail.next = l2;
        }

        return l1;

    }
}