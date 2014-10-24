/**
*思路： 很直接的删除，只不过利用以个dummy点就可以避免判断 head 是不是空 和解决 删除头结点（其实不会，即使重复 也是删head后面的）
*不过 list 类型的题 这样做会方便点，
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
    public ListNode deleteDuplicates(ListNode head) {
    	ListNode dummy = new ListNode(0);

    	dummy.next = head;

    	ListNode pre = dummy;
    	ListNode cur = head;

    	while(cur != null) {
    		if(cur!= head && pre.val == cur.val) {
    			pre.next = cur.next;
    			cur = cur.next;
    		} else {
    			pre = pre.next;
    			cur = cur.next;
    		}
    	}

    	return dummy.next;
    }
}