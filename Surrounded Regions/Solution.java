import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	class pos {
		int x;
		int y;
		pos(int xi, int yi) {
			x = xi;
			y = yi;
		}
	}
    public void solve(char[][] board) {
    	Queue<pos> queue = new LinkedList<pos>();
    	//add all 'O' position at border
    	int row = board.length;
    	if(row == 0)
    		return;
    	int col = board[0].length;// board might be empty
    	for(int i = 0; i < row; ++i){
    		if(board[i][0] == 'O'){
    			pos p = new pos(i, 0);
    			queue.add(p);
    		}
    		if(board[i][col-1] == 'O'){
    			pos p = new pos(i, col-1);
    			queue.add(p);
    		}
    	}
    	for(int j = 0; j < col; ++j) {
    		if(board[0][j] == 'O') {
        		pos p = new pos(0, j);
        		queue.add(p);
    		}
    		if(board[row-1][j] == 'O') {
    			pos p = new pos(row-1, j);
    			queue.add(p);
    		}
    	}
    	
    	while(!queue.isEmpty()){
    			pos reg = queue.remove();
    			int x = reg.x;
    			int y = reg.y;
    			board[x][y] = 'V';
    			if(x > 0 && board[x-1][y] == 'O'){
        			pos p = new pos(x-1, y);
        			queue.add(p);
    			}
    			if(x < row-1 && board[x+1][y] == 'O'){
        			pos p = new pos(x+1, y);
        			queue.add(p);
    			}
    			if(y > 0 && board[x][y-1] == 'O'){
        			pos p = new pos(x, y-1);
        			queue.add(p);
    			}
    			if(y < col-1 && board[x][y+1] == 'O'){
        			pos p = new pos(x, y+1);
        			queue.add(p);
    			}
    	}
    	
    	for(int i = 0; i < row; ++i){
    		for(int j = 0; j < col; ++j){
    			if(board[i][j] == 'O')
    				board[i][j] = 'X';
    		}
    	}
    	for(int i = 0; i < row; ++i){
    		for(int j = 0; j < col; ++j){
    			if(board[i][j] == 'V')
    				board[i][j] = 'O';
    		}
    	}
        
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	char[][] board = {{'X','X', 'X', 'X'},{'X', 'O', 'O', 'X'},{'X', 'X', 'O', 'X'},{'X', 'O', 'X', 'X'}};
    	s.solve(board);
    }
}