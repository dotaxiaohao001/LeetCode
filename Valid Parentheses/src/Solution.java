public class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        char[] stack = new char[len+1];
        stack[0] = '#';
        int top = 0;
        for(int i = 0; i < len; ++i){
        	char ch = s.charAt(i);
        	switch(ch){
        	case '(':
        	case '[':
        	case '{':
        		top++;
        		stack[top] = ch;
        		break;
        	case ')':
        		if(stack[top] == '('){
        			top--;
        			break;
        		}
        		else
        			return false;
        	case ']':
        		if(stack[top] == '['){
        			top--;
        			break;
        		}
        		else
        			return false;
        	case '}':
        		if(stack[top] == '{'){
        			top--;
        			break;
        		}
        		else
        			return false;
        	default:
        		return false;  
        	}
        }
        if(stack[top] == '#')
        	return true;
        else
        	return false;
    }
    public static void main(String args[]){
    	String p = "()[]{}";
    	String q = "()";
    	Solution s = new Solution();
    	System.out.println(s.isValid(p));
    }
}