/**
*思路： 最重要的是divide and conquer， 使得merge O（logn）次 如果像第一次 from start merge to end takes time O（n）次。merge本身是所有的nodes数 
*错误：1 DFS should have base case 否则无限循环！！！， 2 meaningful name。 3 无论什么时候需要index 取element 需要判断是否越界。
*4 typo！！！！
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
    public ListNode mergeKLists(List<ListNode> lists) {
        int size = lists.size();
        if(size == 0)
            return null;
        ListNode listA =  helper(lists, 0, size-1);

        return listA;
    }

    ListNode helper(List<ListNode> lists, int start, int end) {
        //base case!!!
        if(start == end)
             return lists.get(start);
        int mid = start + (end - start) / 2; // avoid start+end out of range
        ListNode listA = helper(lists, start, mid);
        ListNode listB = helper(lists, mid+1, end);

        return mergeList(listA, listB);
    }
    ListNode mergeList(ListNode nodeA, ListNode nodeB) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while(nodeA != null && nodeB != null) {
            if(nodeA.val < nodeB.val) {
                tail.next = nodeA;
                nodeA = nodeA.next;
            } else {
                tail.next = nodeB;
                nodeB = nodeB.next;
            }

            tail = tail.next;
        }
        if(nodeA != null){
            tail.next = nodeA;
        }
        if(nodeB != null) {
            tail.next = nodeB;
        }
        return head.next;
    }
}