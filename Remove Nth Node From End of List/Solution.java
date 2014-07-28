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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //avoid of deleting head p, create assitant head node
        if(head == null || n == 0) return head;

        ListNode mhead = new ListNode(0);
        mhead.next = head;
        ListNode p, cur;
        p = mhead;
        //let p ahead of cur
        for(int i = 0; i < n; ++i)
        	p = p.next;
        cur = mhead;
        while(p.next != null){
        	cur = cur.next;
        	p = p.next;
        }
        //delete cur.next
        cur.next = cur.next.next;

        return mhead.next;

    }
}