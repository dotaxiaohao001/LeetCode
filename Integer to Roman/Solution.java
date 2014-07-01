public class Solution {
    public String intToRoman(int num) {
        String[] symbol = {"M","CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V","IV", "I"};
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuffer result = new StringBuffer();
        for(int i = 0; i < value.length; ++i){
        	int count = num / value[i];
        	num = num % value[i];  // don't define twice.
        	for(int j = 0; j < count; ++j)
        		result.append(symbol[i]); // foolish mistake use the method of special class not just with +
        }

        return result.toString();
    }
}