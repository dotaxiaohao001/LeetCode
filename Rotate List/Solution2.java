/**
*思路： 这道题利用了2 个 pointer p2 p1,p1在p2 n个位置前， 然后可以同时移动p1 p2,直到p2成为tail，折后p2的位置就是更新后tail的最后
*一个点。 p1（是没变之前最后一个点） 讲p1 连接 p2的next p2 连接head 之后返回原来p1的next就是新的head
*这里需要注意的一点就是n 可能 >= length， 所以我在p1move的时候判断， 而且容易犯错的情况是p1move 回head，这就相当与n == 0.所以直接return就好了
*
*错误：p1 p2 老用错，p2 在p1 后面 （左边）。 然后就是p1移到null的判断。 最好立刻变成head 而不是下次iteration再判断，避免null exception
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
    public ListNode rotateRight(ListNode head, int n) {
    	if(head == null || n == 0) {
    		return head;
    	}
    	//use two pointer p2 p1 such that p1 is n position ahead of p2
    	ListNode p1 = head;
    	for(int i = 0; i < n; ++i) {    		
    		p1 = p1.next;
    		if(p1 == null) {
    			p1 = head;
    		}
    	}
    	if(p1 == head) {
    		return head;
    	}
    	ListNode p2 = head;
    	while(p1.next != null) {
    		p1 = p1.next;
    		p2 = p2.next;
    	}

    	ListNode newHead = p2.next;
    	p2.next = p1.next;
    	p1.next = head;
    	return newHead;
    }
}