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
//思路： 基本和第一做的类似，只不过这次利用一个dummy 头结点，避免了判断head == null or not， 有点和merge sort 的思路相似
// 容易出错的点就是l1 and l2 both == null, should check the carry, might be 1! so should add another one node.!!!

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
        	return l2;
        if(l2 == null)
        	return l1;

        ListNode head = new ListNode(0);
        ListNode tail = head;
        int carry = 0;
        while(l1 != null && l2 != null) {
        	int sum = l1.val + l2.val + carry;
        	ListNode d = new ListNode(sum % 10);
        	carry = sum / 10;
        	tail.next = d;
        	tail = d;
        	l1 = l1.next;
        	l2 = l2.next;
        }
        while(l1 != null) {
        	int sum = l1.val + carry;
        	ListNode d = new ListNode(sum % 10);
        	carry = sum / 10;
        	tail.next = d;
        	tail = d;
        	l1 = l1.next;
        }
        while(l2 != null) {
        	int sum = l2.val + carry;
        	ListNode d = new ListNode(sum % 10);
        	carry = sum / 10;
        	tail.next = d;
        	tail = d;
        	l2 = l2.next;
        }
        if(carry == 1) {
        	ListNode d = new ListNode(1);
        	tail.next = d;
        }
        return head.next;
    }
}