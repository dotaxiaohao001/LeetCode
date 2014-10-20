/**
*思路： 主函数其实思路听清楚，先判断是不是 包含e的情况 然后判断是不是包含小数点的情况，但是好多乱七八糟的case 基本再写肯定还有错
*尤其是+.8这种。 
*不过这次发现split 对于..a 和 a.. regex ="\\.” （点）结果不一样。
*别人利用基本的判断好一点http://leetcodenotes.wordpress.com/2013/11/23/leetcode-valid-number/
*蛋疼的题目
*/

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Solution {
	//AeB
	//A coule be integer or decimal B must be integer, if e exists A B must be there even though 0
	public boolean isNumber(String s) {
		if(s == null) {
			return false;
		}
		s = s.trim();
		int len = s.length();
		if(len > 0 && s.charAt(len-1) == 'e') {
			return false;
		}
		String[] part = s.split("e");
		//no e and avoid 123.1e
		if(part.length == 1) {
			return isValidDecimal(part[0]);
		}
		//AeB 
		if(part.length == 2) {
			return isValidDecimal(part[0]) && isValidInteger(part[1]);
		}
		return false;
	}
	//.a  b. a.b
	private boolean isValidDecimal(String s) {
		if(s == null || s.length() == 0) {
			return false;
		}
		int len = s.length();
		int i = 0;
		if(s.charAt(0) == '+' || s.charAt(0) == '-') {
			i++;//ignore sign
		}
		//remain numerial part should be at least > 0
		if(len - i == 0) {
			return false;
		}
		int point = -1;
		for(; i < len; ++i) {
			if(!isDigit(s.charAt(i))) {
				if(s.charAt(i) == '.' && point == -1) {
					point = i; // only allow 1 point
					continue;
				}
				return false;
			}
		}
//		String[] part = s.split("\\.");  // .a will be "" and "a"   a.. would be [a]  ..a would be [,,a]  = = !
		//c
		if(point == -1) {
			return isValidInteger(s);
		}
		//a.b or a. or .b or  b cannot with sign!!!  
		else{
			//.b but +.b is not valid
			if(point == 0) {
				return isValidInteger(s.substring(1, len)) && isDigit(s.charAt(1));
			}
			//a.
			if(point == len-1) {
				return isValidInteger(s.substring(0, len-1));
			}
			//+.1
			if((s.charAt(0) == '+' || s.charAt(0) == '-') || point == 1) {
				return isValidInteger(s.substring(point+1, len)) && isDigit(s.charAt(point+1));
			}
			//a.b
			return isValidInteger(s.substring(0, point)) && isValidInteger(s.substring(point+1, len)) && isDigit(s.charAt(point+1));
		}
	}
	
	//[+-]123
	private boolean isValidInteger(String s) {
		if(s == null || s.length() == 0) {
				return false;
		}
		int len = s.length();
		int i = 0;
		if(s.charAt(0) == '+' || s.charAt(0) == '-') {
			i++;//ignore sign
		}
		//remain numerial part should be at least > 0
		if(len - i == 0) {
			return false;
		}
		
		while(i < len) {
			if(isDigit(s.charAt(i))) {
				i++;
			} else {
				return false;
			}
		}
		return true;
	}
	
	private boolean isDigit(char c) {
		if(c >= '0' && c <= '9') {
	 		return true;
	 	}
	 	return false;
	 }
	//+.8 true
//	public boolean isNumber1(String s) {
//		String regex = "[+-]?(\\d+\\.?|\\.?\\d+)\\d*(e[+-]?\\d+)?";  
//		Pattern pattern = Pattern.compile(regex);
//		Matcher matcher = pattern.matcher(s.trim());
//		return matcher.matches();
//	}
	public static void main(String[] args) {
		  Solution s = new Solution();
		  System.out.println(s.isNumber(" +.1"));
		  System.out.println(Arrays.toString("..o".split("\\.")));
		  System.out.println("..0".split("\\.").length);
	}

}