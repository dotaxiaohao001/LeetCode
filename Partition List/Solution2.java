/**
*思路： 代码还是不要一开始考虑简洁，还是分情况 把每种情况都写出来， 等之后再 合并冗余代码。 这次是记录一个small number的tail，
*如果当前不是点less than target 并且不是tail的之后一个，就可以插到tail后面， 否则直接看下一个。
*但是需要注意的是tail的后一个 和 more than target的处理稍有不同，因为前面的需要移动small tail。
*上次做的是分成两个list然后合并 其实实现起来比较清楚。
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
    public ListNode partition(ListNode head, int x) {
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode smallTail = dummy;
    	ListNode pre = dummy;
    	ListNode cur = head;

    	while(cur != null) {
    		//move pre.next to small tail.next
    		if(cur.val < x) {
    		    if(pre != smallTail) {
    			    pre.next = cur.next;
    			
    			    cur.next = smallTail.next;
    			    smallTail.next =cur;
    			    smallTail = cur;
    			    cur = pre.next;
    		    } else {
    		    	smallTail = smallTail.next;
    		    	pre =pre.next;
    		    	cur = cur.next;
    		    }
    		}else {
		    	pre =pre.next;
		    	cur = cur.next;
    		}
    	}

    	return dummy.next;

    }
}