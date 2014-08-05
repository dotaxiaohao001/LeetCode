public class Solution {
    public int numDistinct(String S, String T) {
        int len1 = S.length();
        int len2 = T.length();
        if(len1 < len2)
        	return 0;
        //f[i][j]: the number of sub T(0~j-1) in S[0~i-1];
        //f[i][j] = f[i-1][j] if S[i-1] != T[j-1] the last is useless
        //f[i][j] = f[i-1][j] + f[i-1][j-1] we can use or not use
        //base case f[0][0] = 1  i >= j

        int[][] f = new int[len1+1][len2+1];
        
        for(int i = 0; i <= len1; ++i)
        	f[i][0] = 1; // there would only one way for empty T for S 

        for(int i = 1; i <= len1; ++i) {
        	for(int j = 1; j <= len2; ++j) {
        		if(S.charAt(i-1) == T.charAt(j-1))
        			f[i][j] = f[i-1][j] + f[i-1][j-1];
        		else
        			f[i][j] = f[i-1][j];
        	}
        }

        return f[len1][len2];
    }


    
    public static void main(String[] args){
    		Solution s = new Solution();
    		int[][] A = {{1,2},{1,1}};
    		System.out.println(s.numDistinct("rabbbit","rabbit"));
    }
}