public class Solution {
	//ugly code
    public String convert(String s, int nRows) {
        int len = s.length();
        if(nRows == 1)
        	return s;
        char[][] array = new char[nRows][len];
        boolean[][] mark = new boolean[nRows][len]; 
        int last = 1;
        int count = 0;
        int i = 0;
        int j = 0;
        while(count < len) {
        	int dir = getDirection(array, nRows, len, i, j, last);
        	array[i][j] = s.charAt(count);
        	mark[i][j] = true;
        	count++;
        	if(dir == 1)
        		i++;
        	if(dir == 2) {
        		i--;
        		j++;
        	}
        	last = dir;
        }
        StringBuffer str = new StringBuffer();
        for(i = 0; i < nRows; ++i)
        	for(j = 0; j < len; ++j) {
        		if(mark[i][j]){
        			str.append(array[i][j]);
        		}
        	}

        return str.toString();


    }

    int getDirection(char[][] array, int m, int n, int i, int j, int last) {
    	//1 means down
    	if(last == 1) {
    		if(i+1 < m)
    			return 1;
    		else
    			return 2;
    	}// 2 means up right
    	else {
    		if(i-1 < 0)
    			return 1;
    		else
    			return 2;
    	}
    }
	    
	  public static void main(String args[]) {
		  Solution s = new Solution();
		  System.out.println(s.convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR"));
		  System.out.println(s.convert("AB", 1));
		 
	  }
	}
