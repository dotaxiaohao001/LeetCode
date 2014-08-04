public class Solution {
    public boolean isScramble(String s1, String s2) {
        //if s1 is scrambled string of s2 there would be true (s11 scr s21 && s12 scr s22 || s11 scr s22 && s12 scr s21)
        int len = s1.length();
        if(len != s2.length())
        	return false;
        if(len == 0)
        	return true;

        boolean[][][] R = new boolean[len+1][len][len]; // use R[n][i][j] to save s1(i,i+n-1)  is scr s2(j,j+n-1)

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for(int i = 0; i < len; ++i) {
        	for(int j = 0; j < len; ++j) {
        		R[1][i][j] = c1[i] == c2[j];
        	}
        }

        for(int l = 2; l <= len; ++l) // l from 2 ~ len
        	for(int i = 0; i + l <= len; ++i)
        		for(int j = 0; j + l <= len; ++j)
        			for(int k = 1; k < l; ++k) { // part k from 1 ~ len-1
        				// i + k should < len k < l => i + k < i + l <= len
        				//System.out.println(R[k][i][j] + " " + R[l-k][i+k][j+k] + " " +R[k][i][j+l-k]+ " " +R[l-k][i+k][j]);
        				if( (R[k][i][j] && R[l-k][i+k][j+k]) || (R[k][i][j+l-k] && R[l-k][i+k][j]) ){
        					R[l][i][j] = true;
        					break;
        				} // function more than one line should be add {}  fuck!!!
        			}
        		
        	
        

       	return R[len][0][0];

    }

    
    public static void main(String[] args){
    		Solution s = new Solution();
    		System.out.println(s.isScramble("abb","bab"));
    }
}