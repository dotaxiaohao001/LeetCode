/**
*思路： 感觉这种题还是要严格按定义，一开始 我只是判断当前点比left child 大 比right child 小， 然后左右子树都满足 就可以，
*但是这样会出现我下面注释出现的错误，左子树中的右叶结点比最上面的root大。  定义里，是left subtree 只包含小于root的点，
*所以这里需要一个helper 因为要用到max min 值，当我们的当前到这个范围 就说明没有超出他的parent root   
*
*错误： 粗心把valid 的情况写出 invalid  第一次写的更简洁 因为root 判断子节点是多余的，因为子树自己判断就好了
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
    public boolean isValidBST(TreeNode root) {
    	return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean helper(TreeNode root, int min, int max) {
    	if(root == null) {
    		return true;
    	}
    	if(root.val <= min || root.val >= max) { //	if(root.val >= min || root.val <= max) 
    		return false;
    	}
    	if(root.left != null && root.left.val >= root.val) {
        	return false;
        }
        if(root.right != null && root.right.val <= root.val) {
        	return false;
        }
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}


//{10,5,15,#,#,6,20}

// public class Solution {
//     public boolean isValidBST(TreeNode root) {
//         if(root == null) {
//         	return true;
//         }

//         if(root.left != null && root.left.val >= root.val) {
//         	return false;
//         }
//         if(root.right != null && root.right.val <= root.val) {
//         	return false;
//         }

//         return isValidBST(root.left) && isValidBST(root.right);
//     }
// }