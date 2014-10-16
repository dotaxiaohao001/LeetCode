/**
*思路： n queen 问题其实和sudoku solver是一类问题，基本就是用recusion的方法试所有可能的情况，行就往下继续， 不行就回溯。
*主要的难点还是再 validcheck 上， 一开始我只是用2个boolean array row[n] col[n]记录哪些row 和col不能用，但是当需要check diagonal
*的时候就基本做不出来了， 所以在这个解法里，利用一个length 为n的数组 记录每一行queen的位置，这样得到得信息多的多，之后判断diagonal
*只要检查r- r· = |c - c·| 因为slope 是正负1。  
*
*错误：其他错误 比如stringbuilder 的 setCharAt（x， i）， 和array copy的函数。
*感觉向上次做的 再最后统一处理string， str.setCharAt(c, 'Q')没有必要，基本solution 没用，所以看 solution3 ==》
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<String[]> solveNQueens(int n) {	
    	int columnAtRow[] = new int[n];
    	
        ArrayList<String[]> result = new ArrayList<String[]>();
        String[] solution = new String[n];
        helper(result, solution, n, 0, columnAtRow);
        return result;
    }

    private void helper(ArrayList<String[]> result, String[] solution, int n, int r, int columnAtRow[]) {
    	if(r == n) {
    		String[] newSolution = new String[n];
    		System.arraycopy(solution, 0, newSolution, 0, n);
    		result.add(newSolution);
    		return;
    	}
    	StringBuilder str = new StringBuilder("");
    	for(int i = 0; i < n; ++i) {
    		str.append('.');
    	}

    	for(int c = 0; c < n; ++c) {
    		if(isValidPosition(columnAtRow, r, c)) {
    			columnAtRow[r] = c; 
    			str.setCharAt(c, 'Q');
    			solution[r] = str.toString();
    			helper(result, solution, n, r+1, columnAtRow);
    			str.setCharAt(c, '.');
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
		for(String[] sa : s.solveNQueens(0)) {
			System.out.println(Arrays.toString(sa));
		}
	}

}