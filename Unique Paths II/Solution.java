public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int row = obstacleGrid.length;
    	if(row == 0)
    		return 0;
    	int col = obstacleGrid[0].length;

    	int[][] path = new int[row+1][col+1];
    	path[row-1][col] = 1;

    	for(int i = row-1; i >= 0; --i){
    		for(int j = col-1; j >= 0; --j){
    			if(obstacleGrid[i][j] == 1){// the only difference
    				path[i][j] = 0;
    			}else{
    				path[i][j] = path[i+1][j] + path[i][j+1];
    			}
    		}
    	}
    	return path[0][0];     
    }
}