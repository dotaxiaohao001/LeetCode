public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
	    // Let us create a 2D table to store solutions of
	    // subproblems.  C[i][j] will be true if C[0..i+j-1]
	    // is an interleaving of A[0..i-1] and B[0..j-1].

	    int len1 = s1.length();
	    int len2 = s2.length();

	    if(s3.length() != len1+len2)
	    	return false;

	    boolean[][] C = new boolean[len1+1][len2+1];

	    for(int i = 0; i <= len1; ++i) {
	    	for(int j = 0; j <= len2; ++j) {
	    		//base case both are empty
	    		if(i == 0 && j == 0)
	    			C[0][0] = true;
	    		else if(i == 0) // j != 0
	    			C[0][j] = s2.charAt(j-1) == s3.charAt(j-1) && C[0][j-1];
	    		else if(j == 0)
	    			C[i][0] = s1.charAt(i-1) == s3.charAt(i-1) && C[i-1][0]; //s1[0,i-2] == s3[0,i-2]
	    		else 
	    			C[i][j] = (s1.charAt(i-1) == s3.charAt(i+j-1) && C[i-1][j])
	    					  || (s2.charAt(j-1) == s3.charAt(i+j-1) && C[i][j-1]);
	    	}
	    }

	    return C[len1][len2];

    }

    
    public static void main(String[] args){
    		Solution s = new Solution();
    		String s1 = "aabcc";
    		String s2 = "dbbca";
    		String s3 = "aadbbcbcac";
    		String s4 = "aadbbbaccc";
    		System.out.println(s.isInterleave(s1,s2,s3));
    		System.out.println(s.isInterleave(s1,s2,s4));
    		System.out.println(s.isInterleave("xxy","xxz","xxzxxy"));
    }
}