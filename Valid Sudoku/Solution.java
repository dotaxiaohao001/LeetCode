public class Solution {
    public boolean isValidSudoku(char[][] board) {

		//use the col value to save the number already in for particular row col or box
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for(int i = 0; i < 9; ++i)
        	for(int j = 0; j < 9; ++j){
        		row[i][j] = false;
        		col[i][j] = false;
        		box[i][j] = false;
        	}

        for(int i = 0; i < 9; ++i)
        	for(int j = 0; j < 9; ++j){
        		if(board[i][j] == '.')
        			continue;
        		else{
        			int n = board[i][j] - '1'; // get the value. should be 1 smaller.
        			
        			if(row[i][n] || col[j][n] || box[i/3*3 + j/3][n]) // for the box 0 1 2  the next row 3 4 5
        				return false;
        			else{
        				row[i][n] = true;
        				col[j][n] = true;
        				box[i/3*3 + j/3][n] =true;
        			}
        		}
        	}

        return true;
    }
}