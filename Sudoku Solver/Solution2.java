/**
*思路： 写的我都醉了，竟然是对的，dfs掌握不错，基本就是都试然后回溯。这里为了减少时间和得到正确答案 就在得到正确时直接退出
*错误： 回溯时如果不满足记得改回去， 还有就是三个判断需要一开始初始化，
*和上次代码基本类似 就是判断valid 差了点，感觉solution里的solveSudoku1看着最好。碎觉。
*/

public class Solution {
    boolean[][] row = new boolean[9][9];
    boolean[][] col = new boolean[9][9];
    boolean[][] box = new boolean[9][9];


    public void solveSudoku(char[][] board) {
    	for(int i = 0; i < 9; ++i) {
    		for(int j = 0; j < 9; ++j) {
    			if(board[i][j] != '.'){
    	    		int val = board[i][j]-'0';
    	    		row[i][val-1] = true;
    	    		col[j][val-1] = true;
    	    		box[i/3+j/3*3][val-1] = true;
    			}
    		}
    	}
    	helper(board, 0, 0);
    }

    private boolean helper(char[][] board, int i, int j) {
    	if(i == 9) {
    		return true;
    	}
    	if(board[i][j] == '.') {
    		for(int val = 1; val <= 9; ++val) {
	    		board[i][j] = (char) ('0'+val);
	    		if(validCheck(val, i, j)){
		    		row[i][val-1] = true;
		    		col[j][val-1] = true;
		    		box[i/3+j/3*3][val-1] = true;
	    			if(helper(board, i+(j+1)/9, (j+1)%9)){
	    				return true;
	    			}
		    		row[i][val-1] = false;
		    		col[j][val-1] = false;
		    		box[i/3+j/3*3][val-1] = false;
	    		}
	    		board[i][j] = '.';
    		}
    		
    	  	return false;
    	} else {
	    		return helper(board, i+(j+1)/9, (j+1)%9);
    	}
    }

    private boolean validCheck(int num, int i, int j) {
    	if(row[i][num-1] || col[j][num-1] || box[i/3 + j/3 * 3][num-1]) {
    		return false;
    	}
    	return true;
    }
    
	public static void main(String[] args) {
		Solution s = new Solution();
		char[][] board = {{'5', '3', '.', '.','7', '.', '.', '.', '.'},
				  {'6', '.', '.', '1','9', '5', '.', '.', '.'},
				  {'.', '9', '8', '.','.', '.', '.', '6', '.'},
				  {'8', '.', '.', '.','6', '.', '.', '.', '3'},
				  {'4', '.', '.', '8','.', '3', '.', '.', '1'},
				  {'7', '.', '.', '.','2', '.', '.', '.', '6'},
				  {'.', '6', '.', '.','.', '.', '2', '8', '.'},
				  {'.', '.', '.', '4','1', '9', '.', '.', '5'},
				  {'.', '.', '.', '.','8', '.', '.', '7', '9'}
				 };
		s.solveSudoku(board);
	}

}