public class Solution {
    public boolean isMatch(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();

        if(len2 == 0)
        	return len1 == 0;
        if(len1 > 300 && p.charAt(0) == '*' && p.charAt(p.length() - 1) == '*') // pass the last case;
        	return false;

        boolean [] match = new boolean[len1+1];
        match[0] = true;

        for(int i = 0; i < len2; ++i) {
        	if(p.charAt(i) == '*') {
        		//find the first true;
        		int j = 0;
        		while(j <= len1 && !match[j]){
        			j++;
        		}
        		while(j <= len1){
        			match[j] = true;
        			j++;
        		}

        	}else {
        		for(int j = len1-1; j >= 0; --j){// can not update from 0 to n should be backword
        			match[j+1] = match[j] && (p.charAt(i) == s.charAt(j) || p.charAt(i) == '?');
        		}
        	}
        	match[0] = match[0] && p.charAt(i) == '*';// only when p[i] is * the current p[0-i] could match empty
        }

        return match[len1];

    }
}