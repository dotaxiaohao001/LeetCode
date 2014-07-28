public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
    	ArrayList<String[]> result = new ArrayList<String[]>();
    	int[] qRow = new int[n];
    	for(int i = 0; i < n; ++i)
    		qRow[i] = -1;
        
    }
    private void NQueen(ArrayList<String[]> result, int[] qRow, int start, int n){
    	if(start == n){
    		String[] ans = new String[n];
    		for(int i = 0; i < n; ++i){
    			for(int j = 0; j < n; ++j){
    				if(qRow[i] == j){
    					ans[i] += "Q";
    				}else{
    					ans[i] += ".";
    				}
    			}
    		}
    		result.add(ans);
    		return;
    	}

    	for(int i = 0; i < n; ++i){
    		if(isValid(qRow, start, i)){
    			NQueen(result, qRowm, start+1, n);
    		}
    	}
    }

    private boolean isValid(int[] qRow, int row, int col){
    	//already in different row
    	//check the col and diagnal
    	for(int i = 0; i < row; ++i){
    		if(qRow[i] == col || Math.abs(col - qRow[i]) == row - i)
    			return false;
    	}
    	return true;
    }
}