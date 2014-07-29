import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        Parenthesis(result, n, n, "");
        return result;
    }
    private void Parenthesis(ArrayList<String> result, int left, int right, String ans){
    	if(left > right) return;
    	//left should always <= right // remain number
    	if(left == 0 && right == 0){
    		result.add(ans);
    		return;
    	}

    	if(left > 0){
    		String newAns = new String(ans);
    		newAns += "(";
    		Parenthesis(result, left-1, right, newAns);
    	}
    	if(right > 0){
    		String newAns = new String(ans);
    		newAns += ")";
    		Parenthesis(result, left, right-1, newAns);
    	}
    }

    public static void main(String[] args){
    		Solution s = new Solution();
    		int[] c = {10,1,2,7,6,1,5}; 
    		System.out.println(s.generateParenthesis(3));
    }
}