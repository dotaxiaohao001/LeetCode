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
    public TreeNode sortedArrayToBST(int[] num) {
    	int len = num.length;
    	return BuildSubTree(num, 0, len - 1);
    }

    private TreeNode BuildSubTree(int[] num, int start, int end) {
    	if(start > end)
    		return null;

    	int mid = (start + end) / 2;

    	TreeNode root = new TreeNode(num[mid]);

    	root.left = BuildSubTree(num, start, mid - 1);
    	root.right = BuildSubTree(num, mid + 1, end);

    	return root;

    }
}