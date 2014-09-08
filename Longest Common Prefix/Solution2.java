/* Write a function to find the longest common prefix string amongst an array of strings. */
/**
*思路： 因为是求所有string 的lcp， 所以我们就以第一个string为初始lcp， 然后对每个string 比较更新，r 为所有比较过的lcp。
*这里关键是r 为 最右的的右边一个位置。所以j < r!!
*错误： charAt【j】 jiong 不过相对上次 code 更简便少许
*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
    	int n = strs.length;
        if(n == 0)
        	return "";
        //rightest positon of LCP	
        int r = strs[0].length();	
        for(int i = 1; i < n; ++i) {
        	int j;
        	for(j = 0; j < strs[i].length() && j < r; ++j){
        		if(strs[i].charAt(j) != strs[0].charAt(j)){
        			break;
        		}
        	}
        	r = j;
        }
        return strs[0].substring(0,r);
    }
}