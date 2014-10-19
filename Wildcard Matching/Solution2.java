/**
*思路： 主要是处理 ‘*’， 这里记录遇到的*的位置 和 当时s的位置，然后直接往后匹配，如果之后不行，就回溯，（j = star+1 下一个需要匹配位置）。
*主要是调lastS的位置，它的位置往后移，就*代表多匹配一个char。一直测试，如果匹配整个余下的，再看p 剩下的是不是只剩* 如果是 就是true
*这里的条件判断很容易出错。。。
*/

public class Solution {
    public boolean isMatch(String s, String p) {
    	int m = s.length();
    	int n = p.length();

    	int i = 0;
    	int j = 0;
    	int star = -1; //'*' position
    	int lastS = 0;

    	while(i < m) {
    		if(j < n && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')) {
    			i++;
    			j++;
    			continue;
    		}
    		
    		if(j < n && p.charAt(j) == '*') {
    			while(j+1 < n && p.charAt(j+1) == '*') {
    				j++; // move to the last '*' same effect of multiply ***
    			}
    			star = j;
    			j++;
    			lastS = i;
    			continue;
    		}

    		if(star !=  -1) {
    			j = star + 1;
    			lastS++; // use this '*' match one more char in s
    			i = lastS;
    			continue;
    		}
    		
    		return false; // use for "aa" "a"
    	}
    	while(j < n && p.charAt(j) == '*') {j++;} //use for "" "*""
    	return j == n;
    }
}