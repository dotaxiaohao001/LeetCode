public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] cost = new int[len1+1][len2+1];

        //initial case
        for(int i = 0; i <= len1; ++i) {
        	cost[i][0] = i;
        }

        for(int j = 0; j <= len2; ++j) {
        	cost[0][j] = j;
        }

        for(int i = 1; i <= len1; ++i) {
        	for(int j = 1; j <= len2; ++j) {
        		char c = word1.charAt(i-1);
        		char d = word2.charAt(j-1);

        		if(c == d)
        			cost[i][j] = cost[i-1][j-1];
        		else
        			cost[i][j] = minThree(cost[i-1][j-1], cost[i-1][j], cost[i][j-1]) + 1; 
        			// replace , delete, add. all operations at word1
        	}
        }
        return cost[len1][len2];
    }

    private int minThree(int a, int b, int c) {
    	int min = Math.min(a,b);
    	min = Math.min(min,c);
    	return min;
    }

}