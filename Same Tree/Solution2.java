/**
*思路: 很直接 按照定义来： 判断一个tree 是否相等 就是 1 root equal ? 2 left tree equal 3 right tree equal 如果都满足就是same
*直接dfs， base case 就是root 为 null 
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
        	return true;
        }
        if(p == null || q == null) {
        	return false;
        }

        if(p.val == q.val) {
        	return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}