/**
*思路： reverse linked list 基本现在可以归纳为 讲第一个original 点设为tail 因为会是change 之后点tail，然后每次将tail后面的点插入到
*pre 点（fake head）的之后，有点插入排序的意思， 这样每次都是处理tail， pre， 和 tail的后面的cur就好了。
*上次做的完全不想看， 感觉思路类似就是写的太绕。
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
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode first = head;

		for(int i = 1; i < m; ++i) {
			pre = pre.next;
			first = first.next;
		}
		//reverse sequence, the first node marked as tail, no need to process the first node
		ListNode cur = first.next;
		//reverse from m+1 to n (n-m+1)
		for(int i = m+1; i <= n; ++i) {
			first.next = cur.next;
			cur.next = pre.next;
			pre.next = cur;

			cur = first.next;
		}

		return dummy.next;
	}


	   //  public static void main(String[] args) {
    // 	Solution s = new Solution();
    // 	 ListNode a1 = new ListNode(1);
    // 	 ListNode a2 = new ListNode(2);
    // 	 ListNode a3 = new ListNode(3);
    // 	 ListNode a4 = new ListNode(4);
    // 	 ListNode a5 = new ListNode(5);
    // 	 a1.next = a2;
    // 	 a2.next = a3;
    // 	 a3.next = a4;
    // 	 a4.next = a5;
    // 	 s.reverseBetween(a1, 2, 4);
    // 	//System.out.println(str);
    // }
}