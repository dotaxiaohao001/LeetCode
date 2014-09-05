/**
*note: special case for nRows, cause the getDirection() for the special case will reach out of bound.
*the test case has no 0(ASSII) in String. so could use the default char array value as mark..!!
*/
public class Solution {
    public String convert(String s, int nRows) {
        int len = s.length();
        char[][] pattern = new char[nRows][len];
        boolean[][] mark = new boolean[nRows][len];
        
        //special case nRows == 1
        if(nRows == 1)
        	return s;
       
        int r = 0;
        int c = 0;
        int direction = 1;
        for(int i = 0; i < len; ++i) {
        	pattern[r][c] = s.charAt(i);
        	mark[r][c] = true;
        	direction = getDirection(direction, r, c, nRows);

        	if(direction == 1) {
        		r++;
        	}
        	else {
        		r--;
        		c++;
        	}
        }

        StringBuffer result = new StringBuffer("");
        for(int i = 0; i < nRows; ++i) {
        	for(int j = 0; j < len; ++j) {
        		if(mark[i][j])
        			result.append(pattern[i][j]);
        	}
        }

        return result.toString();
    }

    //last == 1 only when row == nRows will change to 2
    //last == 2 only when row == 0
    private int getDirection(int last, int row, int col, int nRows) {
    	if(last == 1) {
    		if(row == nRows-1) // nRows is boundary !!!
    			return 2;
    		else
    			return 1;
    	}
    	else { // last == 2
    		if(row == 0)
    			return 1;
    		else
    			return 2;
    	}
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	s.convert("AB",1);
    	System.out.println(s.convert("PAYPALISHIRING", 3).equals( "PAHNAPLSIIGYIR" ));
    	char[] c = new char[1];
    	System.out.println(c[0] == 0);
    }

}