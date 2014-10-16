/**代码更加好看
*唯一注意的是：      
*      StringBuilder sb = new StringBuilder();
*      System.out.println(sb.toString().equals("")); // true.  == false
*不像 char【】 For references (anything that holds an object) that is null.
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<String[]> solveNQueens(int n) {	
    	int columnAtRow[] = new int[n];
    	
        ArrayList<String[]> result = new ArrayList<String[]>();
        helper(result, n, 0, columnAtRow);
        return result;
    }

    private void helper(ArrayList<String[]> result, int n, int r, int columnAtRow[]) {
    	if(r == n) {
    		String[] solution = new String[n];
    		for(int i = 0; i < n; ++i) {
    			StringBuilder str = new StringBuilder();
    			for(int j = 0; j < n; ++j) {
    				if(columnAtRow[i] == j) {
    					str.append('Q');
    				} else {
    					str.append('.');
    				}
    			}
    			solution[i] = str.toString();
    		}
    		result.add(solution);
    		return;
    	}
    	StringBuilder str = new StringBuilder("");
    	for(int i = 0; i < n; ++i) {
    		str.append('.');
    	}

    	for(int c = 0; c < n; ++c) {
    		if(isValidPosition(columnAtRow, r, c)) {
    			columnAtRow[r] = c; 
    			helper(result, n, r+1, columnAtRow);
    			//no need to reset cause, always change the value before use.
    		}
    	}
    }
	//row check is not needed
    private boolean isValidPosition(int columnAtRow[], int r, int c) {
    		for(int i = 0; i < r; ++i) {
    			//check column and diagonal of set queens diganal means the slope is 1 or -1
    			if(columnAtRow[i] == c || Math.abs(columnAtRow[i] - c) == r - i) {
    					return false;
    			}
    		}
    		return true;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		for(String[] sa : s.solveNQueens(4)) {
			System.out.println(Arrays.toString(sa));
		}
	}

}