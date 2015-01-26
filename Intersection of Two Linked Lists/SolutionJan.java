/**
*思路：题目特点 类似交集，假如告诉总共的点数，我们count 2 次之后，然后差值就是intersect 的点数，
*但是这里没有总count数，所以我们先计算出各自的count，然后让大的list move forward differece steps
*因为相交点是两个list上都count了的。
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = 0;
        int countB = 0;

        ListNode p = headA;
        while(p != null) {
        	countA++;
        	p = p.next;
        }

        p = headB;
        while(p != null) {
        	countB++;
        	p = p.next;
        }

        if(countA > countB) {
        	int step = countA - countB;
        	for(int i = 0; i < step; ++i) {
        		headA = headA.next;
        	}
        } else {
        	int step = countB - countA;
        	for(int i = 0; i < step; ++i) {
        		headB = headB.next;
        	}
        }

        while(headA != null && headB != null) {
        	//find intersect node
        	if(headA == headB) {
        		return headA;
        	}
        	headA = headA.next;
        	headB = headB.next;
        }
        //no intersection
        return null;
    }
}