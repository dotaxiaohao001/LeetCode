/**
*implement the straight thinking way. 但是因为用了stringbuilder， 所以base case 不能是仅仅left == n, 那样的话 会造成结果有误（数量是对）， 
*得用string， 使得每一步的结果都能是独立的 所以只需要关心步数
*
*dps基本思路大致理清 就好
*/

import java.util.ArrayList;

public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList();
        StringBuilder oneCase = new StringBuilder();
        helper(0, 0, result, oneCase, n);
        return result;
    }
// left means '(' used, right means ')' used
    void helper(int left, int right, ArrayList<String> result, StringBuilder oneCase, int n) {
    	if(left > n || right > n)
    		return;
    	if(left == n && right == n) {
    		result.add(oneCase.toString());
    		return;
    	}
    	
    	if(left > right) {
    		//add '('
    		oneCase.append('(');
    		helper(left + 1, right, result, oneCase, n);
    		oneCase.deleteCharAt(oneCase.length()-1);
    		//add ')'
    		oneCase.append(')');
    		helper(left, right+1, result, oneCase, n);
    		oneCase.deleteCharAt(oneCase.length()-1);
    	}
    	
    	if(left == right) {
    		//can only add '('
    		oneCase.append('(');
    		helper(left + 1, right, result, oneCase, n);
    		oneCase.deleteCharAt(oneCase.length()-1);
    	}
    	//left < right 
    	//implicitly return 
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.generateParenthesis(3));
    }

}