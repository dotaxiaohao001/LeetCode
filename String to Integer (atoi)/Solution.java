public class Solution {
    public int atoi(String str) {
        //ignore all whitespace at first
        int cur = 0;
        int len = str.length();
        int sign = 1;
        int number = 0;
        while( cur < len && str.charAt(cur) == ' '){
        	cur++;
        }
        //check positive or negative
        if(cur < len && (str.charAt(cur) == '+'||str.charAt(cur) == '-')){
        	//cur < len && should put first +-2 error
        	if(str.charAt(cur) == '-')
        		sign = -1;
        	cur++;
        }
        //get those number
        int digit;
        while(cur < len){
        	if(str.charAt(cur) < '0' || str.charAt(cur) >'9')//not and
        		break;
        	digit = str.charAt(cur) - '0';
        	//check the range border
        	if(number == Integer.MAX_VALUE/10){
        		if(sign == 1 && digit >= 7)
        			return Integer.MAX_VALUE;
        		if(sign == -1 && digit >= 8)
        			return Integer.MIN_VALUE;
        	}
        	if(number > Integer.MAX_VALUE/10){
        		if(sign == 1)
        			return Integer.MAX_VALUE;
        		else
        			return Integer.MIN_VALUE;
        	}
        	number = number * 10 + digit;
        	cur++; 
        }

        return sign * number;

    }
}