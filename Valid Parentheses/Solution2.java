/**
*思路： 括号匹配 写过一万次，主要就是利用stack 当是左括号就push 右括号 如果匹配就pop 否则不匹配
*错误： 这里的一个tricky case: 单个右括号，stack.peek()需要是stack 非空，所以我觉得else if（stack 非空）里面再判断三种对应的右括号更加清晰！
*总之bound check，never forget
*/

public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0)
        	return true;

        int len = s.length();
       	Stack stack = new Stack();

        for(int i = 0; i < len; ++i) {
        	char c = s.charAt(i);
        	//push operation if open kuo hao
        	if(c == '(' || c == '[' || c == '{')
        		stack.push(c);
        	else if(!stack.empty() && c == ')') {
        		if(stack.peek() == '(')
        			stack.pop();
        		else
        			return false;
        	}
        	else if(!stack.empty() && c == ']') {
        		if(stack.peek() == '[')
        			stack.pop();
        		else
        			return false;
        	}
        	else if(!stack.empty() && c == '}') {
        		if(stack.peek() == '{')
        			stack.pop();
        		else
        			return false;
        	}
        	else
        		return false;
        }

        return stack.empty();
    }
}