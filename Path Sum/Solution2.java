/**
*思路： path sum 因为需要从root 一直到leaf 所以我们可以每经过一个点， sum 减去 当前root 如果是leave了
*那么以当前leave node 的val 需要为sum才是所需要的点，otherwise回溯继续判断， 我们这里用到了一个helper函数
*利用一个remain 来代表当前子树所求的sum
*-》上次写的答案更为简洁，思路是一样，因为helper不用新的variable，所以直接利用原函数求出所需要的boolean值就好了。
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
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root == null) {
    		return false;
    	}
    	return hasPathSumHelper(root, sum);
    }

    private boolean hasPathSumHelper(TreeNode root, int remain) {
    	if(root.left == null && root.right == null) {
    		return remain == root.val;
    	}

    	remain -= root.val;

    	boolean leftSubTree = false;
    	if(root.left != null) {
    		leftSubTree = hasPathSumHelper(root.left, remain);
    	}

    	if(leftSubTree) return true;

    	boolean rightSubTree = false;
    	if(root.right != null) {
    		rightSubTree = hasPathSumHelper(root.right, remain);
    	}
    	return leftSubTree || rightSubTree;
    }
}