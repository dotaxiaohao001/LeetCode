public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if(len == 0)
        	return "";

        int r = strs[0].length();
        for(int i = 1; i < len; ++i){
        	int n = 0;
        	for(int j = 0; j < strs[i].length() && j < r; ++j){
        		if(strs[0].charAt(j) == strs[i].charAt(j))
        			n++;
        		else
        			break;
        	}
        	r = n;
        }
        
        return strs[0].substring(0,r);

    }
}