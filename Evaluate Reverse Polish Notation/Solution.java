public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack();

        int len = tokens.length;
        if(len == 0)
        	return 0;

        for(int i = 0; i < len; ++i) {
        	String c = tokens[i];
        	if(isOperator(c)) {
        		//get operands
        		int ope2 = s.pop();
        		int ope1 = s.pop();
        		int ans = 0;
        		if(c.equals("+")) {
        			ans = ope1 + ope2;
        		}
        		if(c.equals("-")) {
        			ans = ope1 - ope2;
        		}
        		if(c.equals("*")) {
        			ans = ope1 * ope2;
        		}
        		if(c.equals("/")) {
        			ans = ope1 / ope2;
        		}
        		s.push(ans);
        	}else {// is number
        		int num = Integer.parseInt(c);
        		s.push(num);
        	}
        }
        return s.pop();
    }

    public boolean isOperator(String c) {
    	if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/"))
    		return true;
    	else
    		return false;
    }
}