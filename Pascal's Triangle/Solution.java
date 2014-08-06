import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
    	ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
    	if(numRows == 0)
    		return triangle;

    	ArrayList<Integer> row = new ArrayList<Integer>();
    	row.add(1);
    	triangle.add(row);
        for(int i = 1; i < numRows; ++i) { // get the left row
        	ArrayList<Integer> lastRow = triangle.get(i-1);
        	ArrayList<Integer> curRow = new ArrayList<Integer>();
        	int pre = 0;
        	//get all the value except the last one
        	for(int v : lastRow) {
        		curRow.add(pre + v);
        		pre = v;
        	}
        	//add the last one
        	curRow.add(pre);
        	triangle.add(curRow);
        }
        return triangle;
    }

  public static void main(String args[]) {
	  Solution s = new Solution();
	  System.out.println(s.generate(5));
	 
  }
}
