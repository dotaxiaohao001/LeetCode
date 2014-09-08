/*
Symbols are placed from left to right in order of value, starting with the largest. However, in a few specific cases,[2] to avoid four characters being repeated in succession (such as IIII or XXXX) these can be reduced using subtractive notation as follows:[3][4]

the numeral I can be placed before V and X to make 4 units (IV) and 9 units (IX) respectively
X can be placed before L and C to make 40 (XL) and 90 (XC) respectively
C can be placed before D and M to make 400 (CD) and 900 (CM) according to the same pattern[5]
*/

/**
*思路：类似与钱，每一个symbol代表相应的面额，所以从大往小整除 会得最终的排列。
*错误： stringbuffer 不支持 + operation, the append() is right!!, and also result typo....make same mistakee....
*/

public class Solution {
    String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public String intToRoman(int num) {
        StringBuffer result = new StringBuffer();
        
        for(int i = 0; i < symbol.length; ++i) {
        	//q means quotient
        	int q = num / value[i];
        	//r means remainder
        	int r = num % value[i];

        	for(int j = 0; j < q; ++j)
        		result.append(symbol[i]); //result += symbol[i];

        	num = r;
        }

        return result.toString();
    }
}