/**
*思路： 相比自己上次的做法（考虑所有情况）， 这里思路是，1 当前一层由四个边组成，我们依次add 就好了，因为边的长度一定，for loop的i可以
*与当前x y 无关。 因为每次层都是 右 下 左 上 =》 next level。 
*注意这里的base case 有2种情况，一种就是偶数长 高的 matrix 最后一层刚好完成， 2 是 奇数长高，这样就会留下1 row or colomn （maybe one element）
*这时想我们单独判断处理一下就好了。 思路比自己想的清晰简单的多，不容易出错。！
*错误：typo.. Array 的 length 是field not method size（）！！！！
*/

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	int m = matrix.length;
    	if(matrix == null || m == 0) {
    		return result;
    	}

    	int n = matrix[0].length;
    	int x = 0;
    	int y = 0;
    	while(m > 0 && n > 0) {
    		//only one row array left -->
    		if(m == 1) {
    			for(int j = 0; j < n; ++j) {
    				result.add(matrix[x][y]);
    				y++;
    			}
    			break;
    		}
    		//only one column array left | v
    		if(n == 1) {
    			for(int i = 0; i < m; ++i) {
    				result.add(matrix[x][y]);
    				x++;
    			}
    			break;
    		}

    		// left top --> lastAdd, right top
    		for(int j = 0; j < n-1; ++j) {
    			result.add(matrix[x][y]);
    			y++;
    		}
    		//now y is already at right top
    		// right top --> lastAdd, right bottom
    		for(int i = 0; i < m-1; ++i) {
    			result.add(matrix[x][y]);
    			x++;
    		}
    		//right bottom -> lastAdd, left bottom
    		for(int j = 0; j < n-1; ++j) {
    			result.add(matrix[x][y]);
    			y--;
    		}

    		//left bottom -> last add, initial start
    		for(int i = 0; i < m-1; ++i) {
    			result.add(matrix[x][y]);
    			x--;
    		}
    		//update to next inner level
    		x = x+1;
    		y = y+1;
    		//shrink the m and n
    		m = m-2;
    		n = n-2;
    	}
    	return result;
    }

	public static void main(String[] args) {
		  Solution s = new Solution();
		  int[][] m = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		  int[][] a = {{1,2}};
		  System.out.println(s.spiralOrder(m));
	}

}