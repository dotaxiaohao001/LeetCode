public class Solution {
    public String longestPalindrome(String s) {
        if(s == null)
        	return null;
        int len = s.length();
        if(len <= 1)
        	return s;

        String maxStr = s.substring(0,1); 
        int maxLen = 1;

        for(int i = 0; i < len; ++i){
        	//from center i
        	String pali = palindrome(i, i, s);
        	if(pali.length() > maxLen){
        		maxStr = pali;
        		maxLen = pali.length();
        	}

        	//from i and i+1
        	pali = palindrome(i, i+1, s);
        	if(pali.length() > maxLen){
        		maxStr = pali;
        		maxLen = pali.length();
        	}
        }
        return maxStr;
    }

    public String palindrome(int i, int j, String s) {
    	int len = s.length();
    	//palindrom from center i ( and j = i+1)
    	while(i >= 0 && j < len && s.charAt(i) == s.charAt(j)){
    		i--;
    		j++;
    	}

    	return s.substring(i+1, j);//i and j is not valid,
    }
}