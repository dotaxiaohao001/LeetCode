/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    public ListNode sortList(ListNode head) {
    	if(head == null || head.next == null)
    		return head;
    	ListNode fast = head;
    	ListNode slow = head;
    	ListNode pre = null;
    	while(fast != null && fast.next != null){
    		pre = slow;
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	ListNode second = slow;
    	pre.next = null;
    	ListNode first = head;

    	ListNode l1 = sortList(first);
    	ListNode l2 = sortList(second);

    	return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode dummy = new ListNode(0);
    	ListNode tail = dummy;
    	while(l1 != null && l2 != null){
    		if(l1.val < l2.val){
    			tail.next = l1;
    			l1 = l1.next;
    		}else{
    			tail.next = l2;
    			l2 = l2.next;
    		}
    		tail = tail.next;
    		tail.next = null;
    	}

    	tail.next = l1 != null? l1 : l2;

    	return dummy.next; 
    }
}