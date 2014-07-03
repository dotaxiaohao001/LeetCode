public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> left = new Stack<Integer>();
        int len = s.length();

        int max = 0;
        int start = -1;// start should be the last ')' not the latest '(' the case ()()
        for(int i = 0; i < len; ++i){
        	char c = s.charAt(i);
        	if(c == '(')
        		left.push(i);
        	else { // ')'
        		if(left.empty())
        			start = i; // the last '(''
        		else {
        			left.pop();
        			int l = 0; // the checked valid match length;

        			if(left.empty()) { // the nearest char left to valid match is ')', so get the start
        				l = i - start;
        			}else {
        				// the left to valid match is '(', from 0
        				l = i - left.peek();
        			}

        			if(max < l)
        				max = l;
        		}
        	}
        }
        return max;
    }
}