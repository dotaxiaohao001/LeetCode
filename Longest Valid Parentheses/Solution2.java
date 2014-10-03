/**
*思路： 跟判断括号匹配类似，只不过这里判断长可能匹配长度。 同理：if 左括号 push 它的index。 
* 当 if 右括号。 1.如果stack为空则说明，在start+1 到 当前i-1 为最大可能匹配。 但是当前的右括号位置 将可能是以后匹配的起始位置 所以更新start（default is -1）
* 当stack 不为空的时候，我们就pop出来，然后计算当前长度为 i - pop之后的栈顶。
*
*/

public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() < 2) {
        	return 0;
        }
        int len = s.length();
        Stack<Integer> stack = new Stack<Integer>();

        int start = -1;
        int max = 0;
        for(int i = 0; i < len; ++i) {
        	char c = s.charAt(i);

        	if(c == '(') {
        		stack.push(i);
        	} else {
        		if(stack.empty()) {
        			start = i;
        		} else {
        			stack.pop();
        			max = stack.empty() ? Math.max(max, i - start) : Math.max(max, i - stack.peek());
        		}
        	}
        }
        return max;
    }
}