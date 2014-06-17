public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length; // use n instead of len would be more readable

        int bi = n / 2; // block i
        int bj;
        if(n % 2 == 0)
        	bj = n / 2;
        else
        	bj = (n + 1) / 2;

        for(int i = 0; i < bi; ++i)
        	for(int j = 0; j < bj; ++j){
        		int temp = matrix[i][j];
        		// left -> top
        		matrix[i][j] = matrix[n-1-j][i];
        		//bottom -> left
        		matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
        		//right -> bottom
        		matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
        		//top -> right
        		matrix[j][n-1-i] = temp;
        	}
    }
}