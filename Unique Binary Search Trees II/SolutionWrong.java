

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */

public class SolutionWorong {
	
	 public class TreeNode {
		    int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; left = null; right = null; }
		  }


	
    public ArrayList<TreeNode> generateTrees(int n) {
    	return buildSubTree(1, n);
	}

	private ArrayList<TreeNode> buildSubTree(int from, int end) {
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		if(from > end) {
			result.add(null);
			return result;
		}
		for(int i = from-1; i < end; ++i){
			ArrayList<TreeNode> l1 = buildSubTree(from, i);
			ArrayList<TreeNode> l2 = buildSubTree(i+1, end-1);

			for(TreeNode node1: l1) // node1 might be changed, so here only if we could copy node1 otherwise should not change the pointer in node1
				for(TreeNode node2: l2) {
					TreeNode nodeN = new TreeNode(end);

					TreeNode head = node1;
					if(node1 == null)
						head = nodeN;
					else{
						while(node1.right != null){
							node1 = node1.right;
						}
						node1.right = nodeN;
					}
					nodeN.left = node2;
					result.add(head);
				}
		}

		return result;		

	}

}