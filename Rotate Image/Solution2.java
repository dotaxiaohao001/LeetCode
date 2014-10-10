/**
*思路:就是找到rotate之后的点和原来点的位置。如何转换。
*这里`是。转换后的位置，假设`为（i,j） 所以i = d1 j = n/2+d2; 然后易得i`+ d2= n/2 j`=d1;
*如今要找到rotate[i][j]的值，则需要找到A[i`][j`]的值即A[n-1-j][i];(将会rotate到ij的原来点的位置)
*
*-------
*|. | `|
*|  |  |
*------- 
*
*/

public class Solution {
    public void rotate(int[][] matrix) {
    	int n = matrix.length;
    	if(n == 0 || n != matrix[0].length) {
    		return;
    	}

    	int[][] rotate = new int[n][n];

    	for(int i = 0; i < n; ++i) {
    		for(int j = 0; j < n; ++j) {
    			rotate[i][j] = matrix[n-1-j][i];
    		}
    	}

    	for(int i = 0; i < n; ++i) {
    		for(int j = 0; j < n; ++j) {
    			matrix[i][j] = rotate[i][j];
    		}
    	}
    }
}