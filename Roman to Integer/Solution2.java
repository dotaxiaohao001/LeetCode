/*
Symbols are placed from left to right in order of value, starting with the largest. However, in a few specific cases,[2] to avoid four characters being repeated in succession (such as IIII or XXXX) these can be reduced using subtractive notation as follows:[3][4]

the numeral I can be placed before V and X to make 4 units (IV) and 9 units (IX) respectively
X can be placed before L and C to make 40 (XL) and 90 (XC) respectively
C can be placed before D and M to make 400 (CD) and 900 (CM) according to the same pattern[5]
*/

/**
*思路：最重要的是如何识别4 和 9， 即当pre < cur. 因为如果小的数放在大数前面， 就代表这两个字母代表四个小的字母， 
*这样因为已经加了1个小，现在又加了5（10）个小， 需要减掉再减掉2个。
*错误：还是typo
*/

public class Solution {
    public int romanToInt(String s) {
        int len = s.length();
        int result = 0;
        int pre = 1000;
        for(int i = 0; i < len; ++i) {
        	int cur = valueOfRomanNumeral(s.charAt(i));

        	//pre >= cur
        	if(pre >= cur) {
        		result += cur;
        	}
        	else { //cur > pre means the precur is represented as 4 pre
        		result += (cur - pre - pre);
        	}
        	pre = cur;
        }

        return result;
    }


    int valueOfRomanNumeral(char c) {
    	//use switch would be better looking
    	int val = 0;
    	if(c == 'I')
    		val = 1;
    	if(c == 'V')
    		val = 5;
    	if(c == 'X')
    		val = 10;
    	if(c == 'L')
    		val = 50;
    	if(c == 'C')
    		val = 100;
    	if(c == 'D')
    		val = 500;
    	if(c == 'M')
    		val = 1000;

    	return val;
    }
}