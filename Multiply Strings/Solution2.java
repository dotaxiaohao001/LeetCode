/**
*思路：上次做没太理解， 主要用到了一个巧妙的方法，用一个len1+len2长的数组记录该位乘得得结果， 因为数字相乘所在的位置与他们
*自身得位置之和有关。 因此这里先reverse  便于处理。 注意可能取0 得情况。
*
*错误：1 last carry 不一定只有1，任何数都有可能以为存得最高非零为可以为81之类得，
*	  2 处理高位0得时候 不是用原来得array是否为0来判断 因为现在得string 很可能比非0array长度大1 要用stringbuilder本身
*     3 stringbuilder 没有equal 用的是sb得object 得，所以只判断是否是同一个object 得用string override得equal
*/
public class Solution {
    public String multiply(String num1, String num2) {
    	StringBuilder n1 = new StringBuilder(num1);
    	StringBuilder n2 = new StringBuilder(num2);
    	n1.reverse();
    	n2.reverse();
    	int len1 = num1.length();
    	int len2 = num2.length();

    	int[] digit = new int[len1 + len2];

    	for(int i = 0; i < len2; ++i) {
    		for(int j = 0; j < len1; ++j) {
    			digit[i+j] += (n2.charAt(i)-'0') * (n1.charAt(j)-'0');
    		}
    	}

    	StringBuilder result = new StringBuilder("");
    	int carry = 0;
    	for(int i = 0; i < len1+len2; ++i) {
    		int d = (digit[i]+carry) % 10;
    		carry = (digit[i]+carry) / 10;
    		result.append(d);
    	}
    	//last carry process
    	if(carry > 0) {
    		result.append(carry);
    	}
    	//remove leading zero
    	int i = len1+len2-1;
    	while(i >=0 && result.charAt(i) == '0') {
    		result.deleteCharAt(i);
    		i--;
    	}
    	//might be zero
    	String ans = result.reverse().toString();
    	return ans.equals("") ? "0" : ans; 
    }

    
public static void main(String[] args) {
	Solution s = new Solution();
	int[] num = {0,1,0,0,9};
	System.out.println(s.multiply("9", "9"));
}

}