/**
*思路：基本和unique path 1 一样，但是这里的path 边界不能向上次直接设置成1， 因为可能不能到达，
*2， 就是假如obstacle 就直接设置成0， 表示无路可走~ 
*上次的做法，是倒置过来做，这样再边界判断 不用判断 依然可以用通用的公式。 不过我觉得这次的正向做法更加好理解点
*错误： 一开始边界的position直接设为1了。呆的1B
*/

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	if(obstacleGrid == null || obstacleGrid.length == 0) {
    		return 0;
    	}

    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;

    	int[][] matrix = new int[m][n];

    	for(int i = 0; i < m; ++i) {
    		for(int j = 0; j < n; ++j) {
    			if(obstacleGrid[i][j] == 1) { // obstacle no path here
    				matrix[i][j] = 0; 
    			} else { // empty space
    				if(i == 0 && j == 0) {
    					matrix[i][j] = 1;
    				} else if(i == 0) {
    					matrix[i][j] = matrix[i][j-1];
    				} else if(j == 0) {
    					matrix[i][j] = matrix[i-1][j];
    				} else {
    					matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
    				}
    			}
    		}
    	}
    	return matrix[m-1][n-1];
    }
}