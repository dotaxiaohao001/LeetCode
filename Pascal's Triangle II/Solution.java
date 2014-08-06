public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
    	ArrayList<Integer> lastRow = new ArrayList<Integer>();
    	lastRow.add(1);
    	if(rowIndex == 0)
    		return lastRow;

    	for(int i = 1; i <= rowIndex; ++i) {
    		ArrayList<Integer> curRow = new ArrayList<Integer>();
    		int pre = 0;
    		for(int v : lastRow) {
    			curRow.add(pre + v);
    			pre = v;
    		}
    		curRow.add(pre);
    		lastRow = curRow;
    	}

    	return lastRow;
    }
}