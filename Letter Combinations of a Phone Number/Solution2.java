/**
*思路：类似求所有可能的解 基本都是dfs，只要不停的回溯 就全部遍历到就好了， 注意边界条件返回。 这里与第一次做的时候用了stringbuilder。(单，快) 
*错误：这里只稍微多考虑了输入为“”　应该返回[""] 而不是直接return [].
*/

import java.util.ArrayList;

public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        String[] dict = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        ArrayList<String> result = new ArrayList<String>();
        if(digits == null)
        	return result;
        StringBuilder str = new StringBuilder();
        helper(result, dict, digits, 0, str);

        return result;
    }

    private void helper(ArrayList<String> result, String[] dict, String digits, int index, StringBuilder str) {
    	if(index == digits.length()) {
    		result.add(str.toString());
    		return;
    	}

    	int num = digits.charAt(index) - '0';

    	for(int i = 0; i < dict[num].length(); ++i) {
    		char c = dict[num].charAt(i);
    		str.append(c);
    		helper(result, dict, digits, index+1, str);
    		str.deleteCharAt(str.length() - 1);
    	}
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.letterCombinations(""));
    }

}