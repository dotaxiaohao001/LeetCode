public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] path = new int[m+2][n+2];
        path[m][n+1] = 1;// path[m+1][n] = 0

        for(int i = m; i > 0; --i)
        	for(int j = n; j > 0; --j) {
        		path[i][j] = path[i+1][j] + path[i][j+1];
        	}

        return path[1][1];
    }
}