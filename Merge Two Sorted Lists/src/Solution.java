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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l, tail, cur;
        l = null;
        tail = null;
    	while(l1 != null && l2 != null){
        	if(l1.val <= l2.val){
        		cur = l1;
        		l1 = l1.next;
        	}
        	else{
        		cur = l2;
        		l2 = l2.next;
        	}
        	if(l == null)
        		l = tail = cur;
        	else{
        		tail.next = cur;
        		tail = tail.next;
        	}
        }
    	//link the left
    	if(l1 != null){
        	if(l == null)
        		l = l1;
        	else
        		tail.next = l1;
    	}
    	if(l2 != null){
        	if(l == null)
        		l = l2;
        	else
        		tail.next = l2;
    	}
    	return l;
    }
}