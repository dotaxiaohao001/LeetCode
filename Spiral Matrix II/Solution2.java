/**
*思路： 基本类似spiral matrix， 还是每次处理4 条 n-1 长度的边 然后更新length n -= 2； 直到base case only one element or 0!
*和上次做的稍有差别，上次做是依据end 和 start 大小 四条边都相关。也需要处理base case， end == start。 
*代码长度基本一样， 只不过我这里把++ 操作分开写了。：）
*/

public class Solution {
    public int[][] generateMatrix(int n) {
    	int[][] matrix = new int[n][n];

    	int x = 0;
    	int y = 0;

    	int num = 1;
    	while(n > 0) {
    		// the last one for odd size matrix
    		if(n == 1) {
    			matrix[x][y] = num;
    			break;
    		}

    		for(int i = 0; i < n-1; ++i) {
    			matrix[x][y] = num;
    			num++;
    			y++;
    		}

    		for(int i = 0; i < n-1; ++i) {
    			matrix[x][y] = num;
    			num++;
    			x++;

    		}

    		for(int i = 0; i < n-1; ++i) {
    			matrix[x][y] = num;
    			num++;
    			y--;
    		}
    		for(int i = 0; i < n-1; ++i) {
    			matrix[x][y] = num;
    			num++;
    			x--;
    		}
    		//current position is at start point of this level
    		//move to inner circle
    		x = x+1;
    		y = y+1;
    		n = n-2;
    	}

    	return matrix;

    }
}