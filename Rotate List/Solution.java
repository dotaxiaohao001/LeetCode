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
        int len = 0;
        if(head == null) return head;// not forget.
        ListNode cur = head;
        ListNode tail = null;
        while(cur != null){
        	len++;
        	if(cur.next == null)
        		tail = cur;
        	cur = cur.next;
        }

        int k = n % len;
        tail.next = head;
       	cur = head;
        for(int i = 1; i < len - k; ++i){
        	cur = cur.next;
        }
        head = cur.next;
        cur.next = null;

        return head;
    }
}