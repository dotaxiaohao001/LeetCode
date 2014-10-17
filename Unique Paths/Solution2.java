/**
*思路： dp的典型题目，当前点的路径 = 左边 + 上边路径数的和。  （commended code 用的是recursion 超时，原因和fib数一样）
*上次做的代码更加简洁， 倒置了一下， 其实相当于在start的左上方有一个假的开始点，然后可以依次更新，也不用边界判断。 
*我这次的做法是直接利用边界的位置的path数肯定唯一， 所以可以方便都设置1，也没有必要单独判断边界
*/

public class Solution {
    public int uniquePaths(int m, int n) {
    	if(m == 0 || n == 0) {
    		return 0;
    	}

    	int[][] matrix = new int[m][n];
    	//start is matrix[0][0]  finish is matrix[m-1][n-1]

    	for(int i = 0; i < m; ++i) {
    		for(int j = 0; j < n; ++j) {
    			if(i == 0 || j == 0) {
    				matrix[i][j] = 1;
    			} else {
    				matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
    			}
    		}
    	}
    	return matrix[m-1][n-1];
    }
}

//time limit exceeeded!!!!
// public class Solution {
//     public int uniquePaths(int m, int n) {
//     	int[] result = {0};

//     	helper(result, 1, 1, m, n);
//     	return result;
//     }

//     private void helper(int result, int i, int j, int m, int n) {
//     	if(i > m || j > n) {
//     		return;
//     	}

//     	if(i == m || j == n) {
//     		result[0]++;
//     		return;
//     	}

//     	//move to right
//     	helper(result, i, j+1, m, n);
//     	//move to bottom
//     	helper(result, i+1, j, m, n);
//     }
// }