import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public void solveSudoku(char[][] board) {
        SudokuPart(board, 0);
        //SudokuPart1(board);
    }

    private boolean SudokuPart1(char[][] board){
    	//if(index == 81)
    	//	return true;
    	for(int i = 0; i < 9; ++i){
        	for(int j = 0; j < 9; ++j){
        		if(board[i][j] == '.'){
        			for(int n = 1; n <= 9; ++n){
        				board[i][j] = (char)('0' + n);
        				if(isValid(board, i, j) && SudokuPart1(board))
        					return true;
        				board[i][j] = '.';
        			}
    				return false;
        		}
        	}
        }
    	return true;
    }
    
    private boolean SudokuPart(char[][] board, int index){
    	if(index == 81)
    		return true;
    	int row = index / 9;
    	int col = index % 9;
    	for(int i = row; i < 9; ++i){
        	for(int j = col; j < 9; ++j){
        		if(board[i][j] == '.'){
        			for(int n = 1; n <= 9; ++n){
        				board[i][j] = (char)('0' + n);
        				if(isValid(board, i, j) && SudokuPart(board, index+1))
        					return true;
        				board[i][j] = '.';
        			}
    				return false;
        		}else{
        			return SudokuPart(board, index+1); // can't only only index++. might 
//        			if(SudokuPart(board, index+1))// only used to increase index!!wrong
//        				return true;
//        			else return false;
        		}
        	}
        }
    	return true;
    }

    private boolean isValid(char[][] board, int row, int col){
    	//check row
    	for(int i = 0; i < 9; ++i){
    		if(i != row && board[i][col] == board[row][col])
    			return false;
    	}
    	//check col
    	for(int j = 0; j < 9; ++j){
    		if(j != col && board[row][j] == board[row][col])
    			return false;
    	}
    	//check bloack
    	for(int i = row/3*3; i < row/3*3 + 3; ++i){
    		for(int j = col/3*3; j < col/3*3 + 3; ++j){
    			if(i == row && j == col)
    				continue;
    			if(board[i][j] == board[row][col])
    				return false;
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args){
    		Solution s = new Solution();
    		int[] c = {10,1,2,7,6,1,5}; 
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
    		System.out.print(board);
    }
}