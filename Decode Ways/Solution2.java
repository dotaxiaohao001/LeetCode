public class Solution2 {
    public int numDecodings(String s) {
    	int len = s.length();
    	if(len == 0 || s.charAt(0) == '0')
    			return 0;

    	char[] c = s.toCharArray();
    	int first = 1; // represent s[0,i-2]
    	int second = 1; // represent s[0,i-1]

    	for(int i = 2; i <= len; ++i) {
    			int temp = 0;
    		if(c[i-1] == '0')
    			temp = 0;
    		else
    		 	temp += second;

    		if(c[i-2] == '1' || (c[i-2] == '2' && c[i-1] <= '6')) 
    			temp += first;

    		first = second;
    		second = temp; 
    	}

    	return second;
    }

    
    public static void main(String[] args){
    		Solution s = new Solution();
    		int[][] A = {{1,2},{1,1}};
    		System.out.println(s.numDecodings("102"));
    }
}