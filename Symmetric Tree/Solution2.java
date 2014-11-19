/**
*思路: 其实还是根据定义： symmetric tree 就是 root 不管 leftSubtree 和 右 rightSubtree  对称。然而对于两个tree 判断是不是
*对称就是root1的leftSubTree 与 root2 的rightSubTree 对称 注意！！！不是相等， root1 的right 与 root2 的left 对称 
*感觉非recursion方法就是用preorder（root-》left-》right）） 和 predorder'（root-》right-》left） 得到一样的结果！
*不够level traverse 更好！
*错误： 把子树的对称想成相等！
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
    public boolean isSymmetric(TreeNode root) {
    	if(root == null) {
    		return true;
    	}
    	return symmetricHelper(root.left, root.right);
    }

    private boolean symmetricHelper(TreeNode subLeft, TreeNode subRight) {
    	if(subLeft == null && subRight == null) {
    		return true;
    	}
    	if(subLeft == null || subRight == null) {
    		return false;
    	}
    	if(subLeft.val == subRight.val) {
    	    return symmetricHelper(subLeft.left, subRight.right) && symmetricHelper(subLeft.right, subRight.left);
    	}
    	return false;
    }
}