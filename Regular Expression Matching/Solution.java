public class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        int len1 = s.length();
        int len2 = p.length();

        if(len2 == 0)
        	return len1 == 0;
        if(len2 == 1)
        	return (len1 == 1) && ( (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') );

        //then len2 > 1
        if(p.charAt(1) != '*'){
        	if(len1 < 1) // s can not be empty
        		return false;
        	if(s.charAt(0) != p.charAt(0) && p.charAt(0) != '.')
        		return false;

        	//else then it is matched at index 0
        	return isMatch(s.substring(1), p.substring(1)); 
        }else{// is x*
        	int i = 0;
        	while(i < len1 && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.') ){
        		if( isMatch(s.substring(i), p.substring(2)) )
        			return true;
        		i++;
        	}
        	//maybe s is empty then should not simply return false 
        	//*** the last line meaning is the first 2 of p had matched all s. check left of pattern, see it could be match with empty
        	return isMatch(s.substring(i), p.substring(2));
        }
    }
    
//    public static void main(String[] args) {
//
//    	String s = "aaaaaaaaaaaaab";
//    	String p = "a*a*a*a*a*a*a*a*a*a*a*a*b";
//    	
//    	Solution a = new Solution();
//    	System.out.println(a.isMatch(s, p));
//    }
}