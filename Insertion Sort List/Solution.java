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
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
        	return head;
        	
        ListNode sortHead = null;
        while(head != null){
        	ListNode cur = head;
        	head = head.next;

        	if(sortHead == null || cur.val < sortHead.val) {
        		cur.next = sortHead;
        		sortHead = cur;
        	}else{
        		ListNode p = sortHead;// small or equal to cur
        		while(p != null){
        			if(p.next == null || cur.val < p.next.val){
        				cur.next = p.next;
        				p.next = cur;
        				break;
        			}
        			p = p.next;
        		}
        	}
        }
        return sortHead;
    }
}