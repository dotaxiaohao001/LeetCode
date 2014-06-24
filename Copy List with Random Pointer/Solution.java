/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return head;

        RandomListNode cur = head;
        while(cur != null){
        	RandomListNode newNode = new RandomListNode(cur.label);
        	newNode.next = cur.next;
        	cur.next = newNode;
        	cur = newNode.next;
        }

        //copy the random list
        cur = head;
        RandomListNode p; // cur.next 
        while(cur != null){
            p = cur.next;
        	if(cur.random == null)
        		p.random = null;
        	else{
        		p.random = cur.random.next;
        	}
        	cur = cur.next.next;
        }

        //split the list

        RandomListNode copyHead = head.next;
        cur = head;
        while(cur != null){
        	p = cur.next;
        	RandomListNode temp = p.next;// original node
        	cur.next = temp;//link original list
        	if(temp != null)
        		p.next = temp.next;
        	cur = temp;
        }

        return copyHead;
    }
}