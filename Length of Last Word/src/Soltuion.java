public class Solution {
    public int lengthOfLastWord(String s) {
        String s1 = s.trim();
        int len = s1.length();
        if(len > 0){
        	int i = len - 1;
        	int count = 0;
        	while(i >= 0){
        		if(s1.charAt(i) == ' ')
        			return count;
        		else
        			count++;
        		i--;
        	}
        	return count;
        }
        else
        	return 0;
    }
}