/**
*思路： 和括号匹配是一种 或者说 postfix什么的类似，stack的思路，如果碰到.就不管，因为就是当前路径， ..的话就回到上一级，pop。 如果其他就push
*就等于进入到下一级directory。 这里尤其要注意的是最后处理之后，last char 考虑的情况，如果/ 那operation完成，但是如果是字符还得处理剩余。
*还是上次写的代码精简， 直接利用split将之前的string都分离，然后直接处理就好了，就没有这么多情况考虑。
*不过split //a a//split 不一样，得找时间看一看source code。
*/
import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
    	int len = path.length();
    	Stack<StringBuilder> stack = new Stack<StringBuilder>();
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < len; ++i) {
    		if(path.charAt(i) == '/') {
    			if(sb.length() > 0) {
    				if(sb.toString().equals(".")) {
    					//do nothing
    				} else if (sb.toString().equals("..")) {
    				    if(!stack.empty())
    					    stack.pop();
    				} else {
    					stack.push(sb);
    				}
    				sb = new StringBuilder();;
    			}
    		} else {
    			sb.append(path.charAt(i));
    		}
    	}
    	if(sb.length() > 0) {
    	    if(sb.toString().equals(".")) {
    					//do nothing
    		} else if (sb.toString().equals("..")) {
    			if(!stack.empty())
    			    stack.pop();
    			} else {
    				stack.push(sb);
    		}
    	}
    	
    	StringBuilder result = new StringBuilder();
    	while(!stack.empty()) {
    		result.insert(0, stack.pop());
    		result.insert(0, '/');
    	}

    	return result.length() == 0 ? "/" : result.toString();
    }

	public static void main(String[] args) {
		  Solution s = new Solution();
		  System.out.println(s.simplifyPath("/.."));
	}

}