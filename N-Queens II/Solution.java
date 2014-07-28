import java.util.ArrayList;

public class Solution {
	int result;
    public int totalNQueens(int n) {
        result = 0;
        int[] QRow = new int[n];
        for(int i = 0; i < n; ++i)
        	QRow[i] = -1;
        NQueens(QRow, 0, n);
        return result;
    }
    private void NQueens(int[] QRow, int start, int n){
    	if(start == n){
    		result++;
    		return;
    	}

    	for(int i = 0; i < n; ++i){
    		if(isValid(QRow, start, i)){
    			QRow[start] = i;
    			NQueens(QRow, start+1, n);
    			QRow[start] = -1;
    		}
    	}
    }

    private boolean isValid(int[] QRow, int row, int col){
    	for(int i = 0; i < row; ++i){
    		if(QRow[i] == col || Math.abs(col - QRow[i]) == row - i)
    			return false;
    	}
    	return true;
    }
    
    public static void main(String[] args){
    		Solution s = new Solution();
    		System.out.println(s.totalNQueens(8));
    }
}