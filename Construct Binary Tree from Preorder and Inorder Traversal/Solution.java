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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	int len = preorder.length;

    	return buildSubTree(preorder, 0, len-1, inorder, 0, len-1);
        
    }

    private TreeNode buildSubTree(int[] preorder, int preFrom, int preEnd, int[] inorder, int inFrom, int inEnd) {
    	if(preFrom > preEnd)
    		return null;
    	if(preFrom == preEnd)//only 1 node
    		return new TreeNode(preorder[preFrom]);

    	int rootVal = preorder[preFrom];
    	TreeNode root = new TreeNode(rootVal);

    	int rootIndex = 0;

    	for(int i = inFrom; i <= inEnd; ++i) {
    		if(inorder[i] == rootVal) {
    			rootIndex = i;
    			break;
    		}
    	}

    	int leftLen = rootIndex - inFrom;

    	root.left = buildSubTree(preorder, preFrom + 1, preFrom + leftLen, inorder, inFrom, inFrom + leftLen - 1);
    	root.right = buildSubTree(preorder, preFrom + 1 + leftLen, preEnd, inorder, inFrom + leftLen + 1, inEnd);

    	return root;
    }
}