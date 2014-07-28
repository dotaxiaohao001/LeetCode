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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = null;
        ListNode cur = result;
        while(l1 != null && l2 != null){
        	int sum = l1.val + l2.val + carry;
        	ListNode node = new ListNode(sum % 10);
        	//node.next = null;
        	carry = sum / 10;
        	if(cur == null){
        		result = node;
        		cur = result;
        	}
        	else{
        		cur.next = node;
        		cur = cur.next;
        	}
        	l1 = l1.next;
        	l2 = l2.next;
        }

        while(l1 != null){
        	int sum = l1.val + carry;
        	ListNode node = new ListNode(sum % 10);
        	//node.next = null;
        	carry = sum / 10;
        	if(cur == null){
        		result = node;
        		cur = result;	
        	}else{
        		cur.next = node;
        		cur = cur.next;
        	}
        	l1 = l1.next;
        }

        while(l2 != null){
        	int sum = l2.val + carry;
        	ListNode node = new ListNode(sum % 10);
        	//node.next = null;
        	carry = sum / 10;
        	if(cur == null){
        		result = node;
        		cur = result;
        	}else{
        		cur.next = node;
        		cur = cur.next;
        	}
        	l2 = l2.next;
        }
        
        if(carry > 0){
        	ListNode node = new ListNode(carry);
        	//node.next = null;
        	cur.next = node;
        }

        return result;
    }
}