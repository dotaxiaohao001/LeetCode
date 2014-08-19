/**
*Longest Palindromic Substring
*/
//mistake:
//1. typo: paliSub(PaliSub)
//2. forloop 2nd expression wrong(i < len / i > 0) !!! should be i >= 0

// 思路：
// 动态规划：
// 1.用paliSub[i][j] 表示 substring[i,j]是不是palidorme
// 哈哈哈错误的理解2.更新的时候必须从后往前： 因为1：这样测试的substring length会逐渐增大。直到 len。 如果从前往后难以做到，例如对于1， 开始(0,0), 之后需要(1,1) 然后(0,1)
// 也可以：从前往后
//         for(int j = 0; j < len; ++j) {
//             for(int i = j; i >= 0; --i) {

//另一种思路，遍历所有以 (0) to (len-1) 和 以 (0,1) to (len-2,len-1) 为center的 palidrome
public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(s == null || len < 2)
        	return s;

        boolean[][] paliSub = new boolean[len][len];
        //paliSub[i][j] means the substring(i,j) is pali or not
        for(int i = len-1; i > 0; --i) {
        	for(int j = i; j < len; ++j) {
        		//single letter string 
        		if(i == j)
        			paliSub[i][j] = true;
        		//two word
        		else if(s.charAt(i) == s.charAt(j) && (i+1 == j || paliSub[i+1][j-1]))
        			paliSub[i][j] = true;
        		//else is false
        	}
        }
        int max = 0;
        String result = "";
        for(int i = 0; i < len; ++i)
        	for(int j = i; j < len; ++j) {
        		if(paliSub[i][j] && j+1-i > max) {
        			max = j-i+1;
        			result = s.substring(i, j+1);
        		}
        	}
        return result;
    }
    
    public static void main(String[] args) {
    		Solution s = new Solution();
    		System.out.println(s.longestPalindrome("acbc"));
    }
}