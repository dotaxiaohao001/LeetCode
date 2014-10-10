/**
*思路：这里是in place swap 主要就是将一个matrix分成4块 但是会存在2种一种是even 各自n/2长 一个是除了中心点 i = n/2 j =n/2+1
*假设 在box1里的位置是i = d1， j= d2
*box2里的相对位置是   i = d2, j = (n-1) - d1
*box3里的相对位置是   i = n-1-d1, j = (n-1) - d2
*box4里的相对位置是   i = n-1-d2, j = d1
*求相应位置只要把d1 和d2分别换乘i j ，然后swap的时候遵循规则是谁先被覆盖是存temp然后谁用来覆盖，谁接下来被覆盖，最后覆盖的是被temp
*错误：typo n%2 should be n%2==0 记住odd 判断是!=0不是1！！！！
*/


public class Solution {
    public void rotate(int[][] matrix) {
    	int n = matrix.length;
    	if(n == 0 || n != matrix[0].length) {
    		return;
    	}

    	//divide the matrix into 4 parts
    	//cause n might be odd or even 
    	int row = n/2;
    	int col = n%2==0 ? n/2 : n/2+1;

    	for(int i = 0; i < row; ++i) {
    		for(int j = 0; j < col; ++j) {
    			//swap 4 part
    			int temp = matrix[i][j];
    			matrix[i][j] = matrix[n-1-j][i]; // put 4 to 1
    			matrix[n-1-j][i] = matrix[n-1-i][n-1-j];//put 3 to 4
    			matrix[n-1-i][n-1-j] = matrix[j][n-1-i];//put 2 to 3
    			matrix[j][n-1-i] = temp;//put 1(temp) to 2
    		}
    	}
    }
}