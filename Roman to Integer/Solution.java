public class Solution {
    public int romanToInt(String s) {
    	int pre = 1000;
    	int len = s.length;
    	int result = 0;
    	for(int i = 0; i < len; ++i){
    		int cur = s.charAt(i);
    		if(cur > pre)
    			result += cur - pre - pre;
    		else
    			result += cur;
    		pre = cur;
    	}
    	return result;
    }

    int RomanValue(char c){
    	int v = 0;
    	switch(c){
    		case 'I':
    			v = 1;
    			break;
    		case 'V':
    			v = 5;
    			break;
    		case 'X':
    			v = 10;
    			break;
    		case 'L':
    			v = 50;
    			break;
    		case 'C':
    			v = 100;
    			break;
    		case 'D':
    			v = 500;
    			break;
    		case 'M':
    			v = 1000;
    			break;
    		default:
    			break; 
    	}
    	return v;
    }
}