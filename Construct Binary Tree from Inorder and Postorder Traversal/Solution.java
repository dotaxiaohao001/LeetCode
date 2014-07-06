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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	int len1 = inorder.length;
    	int len2 = postorder.length;

    	return buildSubTree(inorder, 0, len1 - 1, postorder, 0, len2 - 1);


    }
    private TreeNode buildSubTree(int[] inorder, int from1, int end1, int[] postorder, int from2, int end2) {

    	if(from1 > end1)
    		return null;
    	if(from1 == end1)
    		return new TreeNode(inorder[from1]);
    		
    	int rootVal = postorder[end2];
    	TreeNode root = new TreeNode(rootVal);

    	int rootIndex = 0;

    	for(int i = from1; i <= end1; ++i){
    		if(inorder[i] == rootVal){
    			rootIndex = i;
    			break;
    		}
    	}

    	int leftLen = rootIndex - from1;

    	root.left = buildSubTree(inorder, from1, from1 + leftLen - 1, postorder, from2, from2 + leftLen - 1);
    	root.right = buildSubTree(inorder, from1 + leftLen + 1, end1, postorder, from2 + leftLen, end2 - 1);

    	return root;
    }


}