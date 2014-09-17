/**
*思路： 基本如图所画，解决子问题，交换两个的两个点，但是为了处理所有点都相同，加上一个dummy点， 另一个比较好的是second pointer 在while loop再复制，
*这样就不用， 更新的时候多判断first是否为null，因为在while肯定都不为null。
*错误： Dummy， typo。。。命名规则。lower case for variable 。 capitalization only for class!!
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
    public ListNode swapPairs(ListNode head) {
        //pre -> 1st -> 2nd -> next

        if(head == null || head.next == null) {
        	return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode first = head;
        ListNode second = null;

        while(first != null && first.next != null) {
        	second = first.next;

        	//swap first and second
        	pre.next = second;
        	first.next = second.next;
        	second.next = first;

        	//pre -> second -> first -> next
        	//update the pre and move first to next position
        	pre = first;
        	first = pre.next; // new first position
        }

        //if first == null done, if first != null second == null also done, can not swap null with one left node
        return dummy.next;
    }
}