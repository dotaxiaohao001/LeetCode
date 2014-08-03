import java.util.ArrayList;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) { // why here use just list ??  maybe the test case is not use the ArrayList
        int row = triangle.size();
        int[] pathValue = new int[row+1];//row+1 zero
        for(int i = row - 1; i >= 0; --i){
        	List<Integer> list = triangle.get(i);
        	int col = list.size();
        	for(int j = 0; j < col; ++j) {
        		pathValue[j] = minValue(pathValue[j],pathValue[j+1]) + list.get(j);
        	}
        }
        return pathValue[0];
    }

    private int minValue(int a, int b) {
    	if(a < b)
    		return a;
    	else
    		return b;
    }
}