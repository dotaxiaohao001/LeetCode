import java.util.ArrayList;
// really ugly code
public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        int m = matrix.length;
        if(m == 0)
        	return result;
        int n = matrix[0].length;

        boolean[][] visit = new boolean[m][n];

        int i = 0;
        int j = 0;
        int dir;
        int lastdir = 1;
        while((dir = getDirection(visit, m, n, i, j, lastdir)) != -1) {
        	//add i, j to result
        	result.add(matrix[i][j]);
        	visit[i][j] = true;
        	lastdir = dir;
        	//move to the next position
        	//right
        	if(dir == 1)
        		j++;
        	else if(dir == 2)
        		i++;
        	else if(dir == 3)
        		j--;
        	else if(dir == 4)
        		i--;
        }
        //add the last one
        result.add(matrix[i][j]);
        return result;

    }
// m may not be equal to n
    int getDirection(boolean[][] visit, int m, int n, int i, int j, int last) {
    	//right
    	if( last == 1){
    		if(j+1 < n && !visit[i][j+1])
    			return 1;
    		else if(i+1 < m && !visit[i+1][j])
    			return 2;
    	}
    	//down
    	if(last == 2){
    		if(i+1 < m && !visit[i+1][j])
        		return 2;
    		else if(j-1 >= 0 && !visit[i][j-1])
    			return 3;
    	}
    	//left
    	if(last == 3){
    		if(j-1 >= 0 && !visit[i][j-1])
        		return 3;
    		else if(i-1 >= 0 && !visit[i-1][j])
    			return 4;
    	}
    	//up
    	if(last == 4)
    	{
    		if(i-1 >= 0 && !visit[i-1][j])
        		return 4;
    		else if(j+1 < n && !visit[i][j+1])
    			return 1;
    	}
    	return -1;
    }
    
  public static void main(String args[]) {
	  Solution s = new Solution();
	  int[][] m = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
	  int[][] a = {{1,2}};
	  System.out.println(s.spiralOrder(a));
	 
  }
}
