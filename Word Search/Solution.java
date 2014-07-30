import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public boolean exist(char[][] board, String word) {
    	int row = board.length;
    	if(row == 0)
    		return word.length() == 0;

    	int col = board[0].length;

    	int len = word.length();
    	int[][] visited = new int[row][col];

    	for(int i = 0; i < row; ++i){
    		for(int j = 0; j < col; ++j){
    			if(searchWord(board, i, j, visited, 0, word))
    				return true;
    		}
    	}
    	return false;    
    }

    private boolean searchWord(char[][] board, int i, int j, int[][] visited, int step, String word){
    	if(step == word.length()){
    		return true;
    	}

    	// out of range
    	if(i >= board.length || i < 0 || j >= board[0].length || j < 0)
    		return false;
    	//search fail
    	if(visited[i][j] != 0 || board[i][j] != word.charAt(step))
    		return false;
    	//now this step is satisfied
    	visited[i][j] = 1;
    	boolean result = searchWord(board, i-1, j, visited, step+1, word) || //up
    					 searchWord(board, i+1, j, visited, step+1, word) || //bottom
    					 searchWord(board, i, j-1, visited, step+1, word) || //left
    					 searchWord(board, i, j+1, visited, step+1, word); //right
    	visited[i][j] = 0;

    	return result;
    }


    
    public static void main(String[] args){
    		Solution s = new Solution();
    		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    		System.out.println(s.exist(board, "ABCCED"));
    		System.out.println(s.exist(board, "SEE"));
    		System.out.println(s.exist(board, "ABCB"));
    		System.out.println(s.exist(board, ""));
    }
}