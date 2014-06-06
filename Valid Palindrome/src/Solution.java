public class Solution {
    public boolean isPalindrome(String s) {
    	int i = 0;
    	int j = s.length() - 1;
    	while(i <= j){
    		if(!isAlphanumeric(s.charAt(i))){
    			i++;
    			continue;
    		}
    		if(!isAlphanumeric(s.charAt(j))){
    			j--;
    			continue;
    		}
    		if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
    			return false;
    		i++;
    		j--;
    	}
        return true;
    }
    
    public boolean isAlphanumeric(char c){
    	if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') //(c < 'a' && c >'z' is not right)
    		return true;
    	else if(c >= '0' && c <= '9'){
    		return true;
    	}
    	else
    		return false;
    }
    public static void main(String[] args){
    	String str = ".a2A,";
    	String str1 = "   ";
    	Solution s = new Solution();
    	System.out.println(s.isPalindrome(str));
    	System.out.println(s.isPalindrome(str1));
    }
}