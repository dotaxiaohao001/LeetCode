/**
*思路： 主要利用1st row 和 1st col记录本行本列是不是为0， 但是不能直接更新， 你需要先通过遍历原来1st col row 来知道它之后的样子，然后
*再用来记录。 
*上次做也是一样，只是在最后更新0的时候是遍历一般array 判断它的col[0] row[0]是不是有0，是这个点就是0，这样时间必然为(m-1)(n-1).
*我的两次遍历，要看情况，可能是 m-1 + n -1 到 2（m-1）（n-1）。
*
*错误：assignment太多 == 和 = 写错了
*/

public class Solution {
    public void setZeroes(int[][] matrix) {
    	if(matrix == null || matrix.length == 0) {
    		return;
    	}
    	int m = matrix.length;
    	int n = matrix[0].length;

        boolean row0 = false;
        boolean col0 = false;
        for(int i = 0; i < m; ++i) {
        	if(matrix[i][0] == 0) {
        		col0 = true;
        		break;
        	}
        }

        for(int j = 0; j < n; ++ j) {
        	if(matrix[0][j] == 0) {
        		row0 = true;
        		break;
        	}
        }

        //check left (1,1) to (m-1, n-1)

        for(int i = 1; i < m; ++i) {
        	for(int j = 1; j < n; ++j) {
        		if(matrix[i][j] == 0) {
        			matrix[i][0] = 0;
        			matrix[0][j] = 0;
        		}
        	}
        }

        for(int i = 1; i < m; ++i) {
        	if(matrix[i][0] == 0) {
        		for(int j = 1; j < n; ++j) {
        			matrix[i][j] = 0;
        		}
        	}
        }

        for(int j = 1; j < n; ++j) {
        	if(matrix[0][j] == 0) {
        		for(int i = 0; i < m; ++i) {
        			matrix[i][j] = 0;
        		}
        	}
        }

        if(row0) {
        	for(int j = 0; j < n; ++j) {
        		matrix[0][j] = 0;
        	}
        }

        if(col0) {
        	for(int i = 0; i < m; ++i) {
        		matrix[i][0] = 0;
        	}
        }
    }
}