/**
*思路： 就和merge 排序是一样的，唯一值得说的是这次代码利用了一个dummy head 点，这样就不用判断 最开始l为null的情况，和insert 时是否
*插入头节点一个道理。
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if(l1 == null) {
    		return l2;
    	}
    	if(l2 == null) {
    		return l1;
    	}

    	ListNode dummy = new ListNode(0);
    	ListNode tail = dummy;

    	while(l1 != null && l2 != null) {
    		if(l1.val < l2.val) {
    			tail.next = l1;
    			tail = l1;
    			l1 = l1.next;
    		} else {
    			tail.next = l2;
    			tail = l2;
    			l2 = l2.next;
    		}
    	}

    	if(l1 != null) {
    		tail.next = l1;
    	}
    	if(l2 != null) {
    		tail.next = l2;
    	}

    	return dummy.next;
    }
}