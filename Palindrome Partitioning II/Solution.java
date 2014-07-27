public class Solution {
    public int minCut(String s) {
     	int len = s.length();
     	boolean[][] pali = new boolean[len][len];
     	int[] minCut = new int[len];// means the least cut for s[i, end]
     	for(int i = 0; i < len; ++i){
     		minCut[i] = len - i - 1;
     	}
     	char[] letters = s.toCharArray();
     	
     	for(int i = len-1; i >= 0; --i)
     		for(int j = i; j < len; ++j){
     			pali[i][j] = letters[i] == letters[j] && (j-i < 2 || pali[i+1][j-1]);

     			if(pali[i][j]){
     				if(j == len-1){
     					minCut[i] = 0;
     				}
     				else if(minCut[i] > 1+minCut[j+1]){ //cut palindrome(i,j) | minCut(j+1, end)
     					minCut[i] = 1 + minCut[j+1];
     				}
     			}
     		}

     	return minCut[0];
    }
    
    public static void main(String[] args){
    		Solution s = new Solution();
    		System.out.println(s.minCut("abb"));
    }
}