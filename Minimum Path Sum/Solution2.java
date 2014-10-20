/**
*思路： 算法导论的例题，经典dp问题，和unique path 类似，只是处理 i = 0 或者 or 并且 j= 0 时候稍加判断，其他的就逐行逐列更新就好。
*当前位置的大小 只与它的top 和 right 相关 所以取一个个小的更新就行了。
*上次做法 唯一重新声明一个array记录，这个依据情况，我这里直接更改原数组
*/

public class Solution {
    public int minPathSum(int[][] grid) {
    	if(grid == null || grid.length == 0) {
    		return 0;
    	}

    	int m = grid.length;
    	int n = grid[0].length;
    	if(n == 0) {
    		return 0;
    	}

    	for(int i = 0; i < m; ++i) {
    		for(int j = 0; j < n; ++j) {
    			if(i == 0 && j == 0) {
    				 grid[i][j] = grid[i][j];
    			} else if(i == 0) {
    				grid[i][j] += grid[i][j-1];
    			} else if(j == 0) {
    				grid[i][j] += grid[i-1][j];
    			} else {
    				grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
    			}
    		}
    	}

    	return grid[m-1][n-1];
    }
}