/**
*貌似也是典型的动态规划题， = =！
*基本就是，假如，s(1,n) -> s(1,m) 要的cost 与 s(1,n-1) -> s(1,m-1) and s(1,n-1) ->s(1,m) and s(1,n) -> s(1,m-1)的关系
*感觉上次的代码清醒些。
*The following recurrence relations define the edit distance, d(s1,s2), of two strings s1 and s2:
*d('', '') = 0               -- '' = empty string
*d(s, '')  = d('', s) = |s|  -- i.e. length of s
*d(s1+ch1, s2+ch2)
*  = min( d(s1, s2) + if ch1=ch2 then 0 else 1 fi,
*         d(s1+ch1, s2) + 1,
*         d(s1, s2+ch2) + 1 )
*/

public class Solution {
    public int minDistance(String word1, String word2) {
    	int len1 = word1.length();
    	int len2 = word2.length();

    	int[][] cost = new int[len1+1][len2+1];

    	// s to "" should be delete len
    	for(int i = 0; i <= len1; ++i) {
    		cost[i][0] = i;
    	}
    	// "" to s should be insert len
    	for(int j = 0; j <= len2; ++j) {
    		cost[0][j] = j;
    	}

    	// word1 = s1+ch1 word2 = s2+ch2
    	for(int i = 1; i <= len1; ++i) {
    		for(int j = 1; j <= len2; ++j) {
    			// if s1 + ch1 == s2 + ch2  : ch1 == ch2 ? s1 == s2 : s1 == s2 + replace(1)
    			int c1 = word1.charAt(i-1) == word2.charAt(j-1) ? cost[i-1][j-1] : cost[i-1][j-1] + 1;
    			//s1 == s2 + ch2: s1 + ch1 ==> s2 + ch2 delete ch1(1) 
    			int c2 = cost[i][j-1] + 1;
    			//s1 + ch1 + ch3 == s2 + ch2 : s1 + ch1 ==> s2 + ch2 insert ch3(1)
    			int c3 = cost[i-1][j] + 1;
    			cost[i][j] = minThree(c1, c2, c3);
    		}
    	}
    	return cost[len1][len2];
    }

    private int minThree(int a, int b, int c) {
    	if(a < b) {
    		return a < c ? a : c;
    	} else {
    		return b < c ? b : c;
    	}
    }
}