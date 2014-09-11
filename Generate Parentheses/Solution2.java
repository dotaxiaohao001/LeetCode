/**
*思路：典型dps，主要需要思考valid case 的限制条件： 即任意时刻已经用的左括号 大于等于（>=）已经用的右括号数目
*主要分类2case： 1left > right 所以之后可以either '(' or ')'， 2left==right 只能加 '('.
*在本题的解法里， 我用left right 代表剩余的 所以剩余的left 要 小于等于 right才是valid。
*并且因为base case 排除了left 》 right情况， 所以只要有剩余 左右括号都可以尝试。
*
*错误： 自己想的based on subpart 思路是错的， 能产生出答案 但是会有3次重复
*/

import java.util.ArrayList;

public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList();
        StringBuilder oneCase = new StringBuilder();
        helper(n, n, result, oneCase);
        return result;
    }
//left means left '(' remains, right means ')' remains
    void helper(int left, int right, ArrayList<String> result, StringBuilder oneCase) {
    	if(left > right) //invalid condition means right ) has more number to be matched.
    		return;
    	if(left == 0 && right == 0) {
    		result.add(oneCase.toString());
    		return;
    	}
    	
    	if(left > 0) {
    		oneCase.append('(');
    		helper(left - 1, right, result, oneCase);
    		oneCase.deleteCharAt(oneCase.length()-1);
    	}
    	
    	if(right > 0) {
    		oneCase.append(')');
    		helper(left, right-1, result, oneCase);
    		oneCase.deleteCharAt(oneCase.length()-1);
    	}
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.generateParenthesis(3));
    }

}
//another good solution! 
//http://www.programering.com/a/MjN1ATMwATM.html



//wrong solution from me always 3 duplicates, don't related to their left right parts


// import java.util.ArrayList;

// public class Solution {
//     public ArrayList<String> generateParenthesis(int n) {
//         ArrayList<String> result = new ArrayList();
//         result = helper(n, result);
//         return result;
//     }

//     ArrayList<String> helper(int n, ArrayList<String> result) {
//     	if(n == 0) {
//     		result.add(new String(""));
//     		return result;
//     	}
//     	if(n == 1) {
//     		result.add(new String( "()" ));
//     		return result;
//     	}
//     	if(n == 2) {
//     		result.add(new String("()()"));
//     		result.add(new String("(())"));
//     		return result;
//     	}
//     	//n > 2

//     	int l, r;
//     	for(int i = 0; i < n; ++i) {
//     		l = i;
//     		r = n - 1 - l;

//     		ArrayList<String> leftPart = new ArrayList<String>();
//     		ArrayList<String> rightPart = new ArrayList<String>();

//     		leftPart = helper(l, leftPart);
//     		rightPart = helper(r, rightPart);

//     		for(String strL : leftPart) {
//     			for(String strR : rightPart) {
//     				String str1 = new String( "(" + strL + ")" + strR );
//     				String str2 = new String( strL + "()" + strR );
//     				String str3 = new String( strL + "(" + strR + ")" );
//     				result.add(str1);
//     				result.add(str2);
//     				result.add(str3);
//     			}
//     		}
//     	}
//     	return result;
//     }
    
//     public static void main(String[] args) {
//     	Solution s = new Solution();
//     	System.out.println(s.generateParenthesis(3));
//     }

// }