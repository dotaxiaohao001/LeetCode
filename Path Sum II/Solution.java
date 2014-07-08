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


    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    	ArrayList<Integer> s = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	pathCheck(root, sum);
    	return result;
    }

    private void pathCheck(TreeNode root, int sum, ArrayList<Integer> s, ArrayList<ArrayList<Integer>> result){
    	if(root == null)
    		return;
    	if(root.left == null && root.right == null)
    		if(root.val == sum) {
     			s.add(root.val);
    			result.add(new ArrayList<Integer>(s));//should new a object otherwise would change the elements in result
    			s.remove(s.size()-1);
    			return;
    		}else{
    			return;
    		}
    	
    	if(root.left != null) {
    		s.add(root.val);
        	pathCheck(root.left, sum - root.val, s, result);
    		s.remove(s.size()-1);
    	}
    	
    	if(root.right != null) {
    		s.add(root.val);
        	pathCheck(root.right, sum - root.val, s, result);
    		s.remove(s.size()-1);
    	}
    }
    
//    public class TreeNode {
//    	      int val;
//    	      TreeNode left;
//    	      TreeNode right;
//    	      TreeNode(int x) { val = x; }
//    	  }
//    public static void main(String[] args){
//    	Solution s = new Solution();
//    	TreeNode r = s.new TreeNode(1);
//    	//r.left = s.new TreeNode(2);
//    	System.out.println(s.pathSum(r, 1));
//    }
}