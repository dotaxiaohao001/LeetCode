/**
*思路： 和unique 1 一样，主要还是关注bst的性质 比root小的数都在left tree 大的都在right tree，这样subtree 的node数是固定的。然后相应的
*subtree也就是固定的。sum(left*right)[1-n] 就是所有unique的bst。
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    private ArrayList<TreeNode> helper(int start, int end) {
        ArrayList<TreeNode> bst = new ArrayList<TreeNode>();
        //empty tree
    	if(start > end) {
    		bst.add(null);
    		return bst;
    	}

    	//choose i node as root
    	for(int i = start; i <= end; ++i) {
    		ArrayList<TreeNode> leftSubTreeSet = helper(start, i-1);
    		ArrayList<TreeNode> rightSubTreeSet = helper(i+1, end);

    		for(TreeNode leftSubTree : leftSubTreeSet) {
    			for(TreeNode rightSubTree : rightSubTreeSet) {
    				TreeNode root = new TreeNode(i);
    				root.left = leftSubTree;
    				root.right = rightSubTree;
    				bst.add(root);
    			}
    		}
    	}
    	return bst;
    }
}