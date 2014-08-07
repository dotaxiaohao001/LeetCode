public class Solution {
    public String multiply(String num1, String num2) {
        StringBuffer s1 = new StringBuffer(num1);
        s1 = s1.reverse();
        StringBuffer s2 = new StringBuffer(num2);
        s2 = s2.reverse();

        int len1 = s1.length();
        int len2 = s2.length();

        int[] digit = new int[len1+len2];

        for(int i = 0; i < len1; ++i) {
        	for(int j = 0; j < len2; ++j) {
        		int b1 = s1.charAt(i) - '0';
        		int b2 = s2.charAt(j) - '0';

        		//the digit of answer get from all (digit place sum equal to answer digit place)
        		digit[i+j] += b1 * b2; // sum!!!
        	}
        }

        //process the carry
        StringBuffer str = new StringBuffer();
        for(int i = 0; i < len1+len2; ++i) {
        	int d = digit[i] % 10;
        	int carry = digit[i] / 10;
        	if(carry > 0) // the last can't have carry
        		digit[i+1] += carry;

        	str.append(d);
        }
        // trim the higher zero
        int i = len1+len2-1;
        while(i >= 0 && str.charAt(i) == '0') {
        	str.deleteCharAt(i);
        	i--;
        }
        //return maybe the result is 0 so the str is ""

        String result = str.reverse().toString();

        return result.equals("") ? "0" : result; // String is object use equal to compare the content not the address with ==
    }

  public static void main(String args[]) {
	  Solution s = new Solution();
	  System.out.println(s.multiply("123","456"));
	  System.out.println(s.multiply("100", "0"));
	 
  }
}
