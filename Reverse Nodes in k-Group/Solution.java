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
    public ListNode reverseKGroup(ListNode head, int k) {
    	if(head == null ) return head;

    	ListNode mhead = new ListNode(0);
    	mhead.next = head;

    	ListNode pre, cur;
    	pre = mhead;
    	cur = head;
    	int len = 0;
    	while(cur != null){
    		len++;
    		cur = cur.next;
    	}
        int count = len/k;

        for(int j = 0; j < count; ++j){
        	ListNode first, second;
        	first = pre.next;
        	second = first.next;
        	for(int i = 1; i < k; ++i){
        		first.next = second.next;
        		second.next = pre.next;
        		pre.next = second;

        		second = first.next;
        	}

        	pre = first;
        }

        return mhead.next;
    }
}