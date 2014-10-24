/*
*思路： 和之前基本一样，只不过现在我用两个pointer，记录连续不同数字的头位置，如果他们只相差1 那么前一个数字就是valid，否则就跳过
*这里因为q是用到head。next 所以开始要测试head 是否为空， 
*还有就是对于最后一个点的除了，因为q变成null之后当作新的q，只是还要check，但是注意的是假如最后一个点不能的话，需要将pre更新为null(特别容易错 这里)
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
        if(head == null) {
            return head;
        }
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode pre = dummy;
    	ListNode p = head;
    	ListNode q = head.next;
    	while(q != null) {
    		if(p.val != q.val) {
    			//distinct number
    			if(p.next == q) {
    				pre.next = p;
    				pre = p;
    				p = q;
    				q = q.next;
    			} else {
    				p = q;
    				q = q.next;
    			}
    		} else {
    			q = q.next;
    		}
    	}
    	//process the last one
    	if(p.next == null) {
    		pre.next = p;
    	}else{
    	    pre.next = q;
    	}
    	return dummy.next;
    }
}