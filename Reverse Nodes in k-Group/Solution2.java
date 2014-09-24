/**
*思路： 还是第一遍求length 第二遍就reverse len/k个sublist
*错误： 1. if k == 1 当len == 1时候 cur out of range。
*	   2. 当没有left 更新cur 也会出现out of range
* so 类似第一次解法把tail 和 cur 都放在for loop 更新会更好 see the solution 3
*/

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

        if(len < k || k == 1)
        	return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //the prenode to the reversed list
        ListNode pre = dummy;
        // tail means the reversed list
        ListNode tail = head;
        // node need to insert to the head
        cur = head.next;
        for(int i = 0; i < len/k; ++i) {
        	//reverse len/k list and the left out remain the same
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
        	tail = cur;
        	if(cur != null)
        	cur = cur.next;
        }

        return dummy.next;
    }
}