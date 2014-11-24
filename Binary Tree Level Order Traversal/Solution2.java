/**
*思路： level traversal 就是queue的应用 一般用linkedlist实现， 主要这里的问题是结果存放是一层层的 所以需要2个queue，这里
*做的类似dp 利用nextLevel不断更新curLevel， 和上次做的有差别（remove q1就add q2） （remove q2 就add q1。 不过大体一样
*错误： 感觉method 的return type， List<List<Integer>> 需要讲 generic type E（List<Integr>）变成ArrayList<Integer>
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) {
        	return result;
        }

        Queue<TreeNode> curLevel = new LinkedList<TreeNode>();
        curLevel.add(root);
        while(!curLevel.isEmpty()) {
        	ArrayList<Integer> level = new ArrayList<Integer>();
        	Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
        	while(!curLevel.isEmpty()) {
        		TreeNode cur = curLevel.remove();
        		level.add(cur.val);
        		if(cur.left != null) {
        			nextLevel.add(cur.left);
        		}
        		if(cur.right != null) {
        			nextLevel.add(cur.right);
        		}
        	}
        	result.add(level);
        	curLevel = nextLevel;
        }
        
        return result;
    }
}