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
    public ArrayList<TreeNode> generateTrees(int n) {
    	return buildSubTree(1, n);
	}

	private ArrayList<TreeNode> buildSubTree(int from, int end) {
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		if(from > end) {
			result.add(null);
			return result;
		}
		for(int i = from; i <= end; ++i){
			ArrayList<TreeNode> l1 = buildSubTree(from, i-1);
			ArrayList<TreeNode> l2 = buildSubTree(i+1, end);

			for(TreeNode node1: l1)
				for(TreeNode node2: l2) {
					TreeNode nodeI = new TreeNode(i);
					nodeI.left = node1;
					nodeI.right = node2;
					result.add(nodeI);
				}
		}

		return result;		

	}

}