public class Solution {
    public int[][] generateMatrix(int n) {
        int number = 0;
        int begin = 0;
        int end = n-1;

        int[][] matrix = new int[n][n];

        while(begin < end) {
        	for(int j = begin; j < end; ++j)
        		matrix[begin][j] = ++number;
        	for(int i = begin; i < end; ++i)
        		matrix[i][end] = ++number;
        	for(int j = end; j > begin; --j)
        		matrix[end][j] = ++number;
        	for(int i = end; i > begin; --i)
        		matrix[i][begin] = ++number;

        	begin++;
        	end--;
        }

        if(begin == end)
        	matrix[end][end] = ++number;
        return matrix;
    }
	    
	  public static void main(String args[]) {
		  Solution s = new Solution();
		  int[][] m = s.generateMatrix(3);
		  int[][] a = s.generateMatrix(4);
		  System.out.println(s.generateMatrix(4));
		 
	  }
	}
