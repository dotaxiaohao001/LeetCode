//more elegant than solution2

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
        int len = 0;
        ListNode cur = head;
        while(cur != null) {
        	len++;
        	cur = cur.next;
        }

        if(len < k)
        	return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        //the prenode to the reversed list
        ListNode pre = dummy;

        for(int i = 0; i < len/k; ++i) {
            ListNode tail = pre.next;
            cur = tail.next;

        	//only put k-1 node to the head
        	for(int j = 0; j < k-1; ++j) {
        		//reverse current node
        		tail.next = cur.next;
        		cur.next = pre.next;
        		pre.next = cur;
        		//only update cur, pre tail always be the dummy and head node
        		cur = tail.next;
        	}
        	//update pre
        	pre = tail;
        }

        return dummy.next;
    }
}