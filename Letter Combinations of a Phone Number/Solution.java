import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public String[] letters = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};// 0 - 9

    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        StringBuffer ans = new StringBuffer();
        combinations(digits, 0, result, ans);
        return result;

    }

    private void combinations(String digits, int start, ArrayList<String>result, StringBuffer ans) {
    	if(start >= digits.length()){
    		result.add( new String( ans.toString() ) );
    		return;
    	}

    	int num = digits.charAt(start) - '0';


    	for(int i = 0; i < letters[num].length(); ++i) {
    		ans.append(letters[num].charAt(i));
    		combinations(digits, start+1, result, ans);
    		ans.deleteCharAt(ans.length()-1);
    	}
    }

    public static void main(String[] args){
        Solution s1 = new Solution();
        
        //s.searchInsert(A, 4);
        System.out.println(s1.letterCombinations("1"));
    }
}