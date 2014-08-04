public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m == 0)
        	return 0;
        int n = grid[0].length;

        int[][] R = new int[m][n];
        for(int i = 0; i < m; ++i) {
        	for(int j = 0; j < n; ++j) {
        		if(i == 0 && j == 0) // typo i == 0 && i == 0
        			R[0][0] = grid[0][0];
        		else if(i == 0)
        			R[0][j] = R[0][j-1] + grid[0][j];
        		else if(j == 0)
        			R[i][0] = R[i-1][0] + grid[i][0];
        		else
        			R[i][j] = Math.min(R[i-1][j], R[i][j-1]) + grid[i][j];
        	}
        }

        return R[m-1][n-1];
    }

    
    public static void main(String[] args){
    		Solution s = new Solution();
    		int[][] A = {{1,2},{1,1}};
    		System.out.println(s.minPathSum(A));
    }
}