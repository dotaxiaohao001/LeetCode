// the Brute-Force solution
public class Solution {
    public String strStr(String haystack, String needle) {
        if(haystack == null || needle == null)
        	return null;
        int len = haystack.length();
        int n = needle.length();
        if(len < n)
        	return null;
        // str = "" and null is not the same
        if(n == 0)
        return haystack;

        for(int i = 0; i < len; ++i){
        	int k = i;
        	if(len - i < n) // care for the boundary
        	    break;
        	int j;
        	for(j = 0; j < n; ++j, ++k){
        		if( haystack.charAt(k) == needle.charAt(j) )
        			continue;
        		else
        			break;
        	}
        	if(j == n)
        		return haystack.substring(i);
        }
        return null;
    }
}