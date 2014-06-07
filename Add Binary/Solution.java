public class Solution {
    public String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        StringBuffer result = new StringBuffer();
        int carry = 0;
        for(int i = lenA - 1, j = lenB - 1; i >= 0 || j >= 0; --i, --j){
        	int numA = i >= 0? a.charAt(i) - '0': 0;
        	int numB = j >= 0? b.charAt(j) - '0': 0;
        	int val = (numA + numB + carry) % 2;
        	carry = (numA + numB + carry) / 2;
        	result.insert(0,val);
        }
        if(carry == 1)
        	result.insert(0,1);
        return result.toString();
    }
}