/**
*思路: 和以前做的string add 一样， 先将 a b 倒置， 然后0 就是个位，然后一次相加 只要更新好carry就好了。
*注意， Arrays是没有reverse的函数，所以要先转换成StirngBuilder 用它里面的函数。
*
*上次写的代码更加简洁 利用int numA = i >= 0? a.charAt(i) - '0': 0; 然后直接从后面往前处理。 注释里用了那种方法 貌似是快些！
*/

public class Solution {
    public String addBinary(String a, String b) {
    	if(a == null && b == null) {
    		return null;
    	}
    	if(a == null || a.length() == 0) {
    		return b;
    	}
    	if(b == null || b.length() == 0) {
    		return a;
    	}

    	int lenA = a.length();
    	int lenB = b.length();

    	StringBuilder strA = new StringBuilder(a);
    	StringBuilder strB = new StringBuilder(b);

    	strA.reverse();
    	strB.reverse();

    	StringBuilder sum = new StringBuilder();
    	int i = 0;
    	int carry = 0;
    	while(i < lenA && i < lenB) {
    		int val = (strA.charAt(i) - '0') + (strB.charAt(i) - '0') + carry;
    		sum.insert(0, val%2);
    		carry = val/2;
    		i++;
    	}

    	while(i < lenA) {
    		int val = (strA.charAt(i) - '0') + carry;
    		sum.insert(0, val%2);
    		carry = val/2;
    		i++;
    	}
    	while(i < lenB) {
    		int val = (strB.charAt(i) - '0') + carry;
    		sum.insert(0, val%2);
    		carry = val/2;
    		i++;
    	}
    	if(carry == 1) {
    		sum.insert(0, 1);
    	}
    	return sum.toString();
    }
	public static void main(String[] args) {
		  Solution s = new Solution();
		  System.out.println(s.addBinary("1", "11"));
	}
}


// public class Solution {
//     public String addBinary(String a, String b) {
//     	if(a == null && b == null) {
//     		return null;
//     	}
//     	if(a == null || a.length() == 0) {
//     		return b;
//     	}
//     	if(b == null || b.length() == 0) {
//     		return a;
//     	}

//     	int lenA = a.length();
//     	int lenB = b.length();

//     	StringBuilder strA = new StringBuilder(a);
//     	StringBuilder strB = new StringBuilder(b);

//     	strA.reverse();
//     	strB.reverse();

//     	StringBuilder sum = new StringBuilder();
//     	int i = 0;
//     	int j = 0;
//     	int carry = 0;
//     	while(i < lenA || j < lenB) {
//     		int valA = i < lenA ? strA.charAt(i) - '0' : 0;
//     		int valB = j < lenB ? strB.charAt(j) - '0' : 0;
//     		int val = valA + valB + carry;
//     		sum.insert(0, val%2);
//     		carry = val/2;
//     		i++;
//     		j++;
//     	}

//     	if(carry == 1) {
//     		sum.insert(0, 1);
//     	}
//     	return sum.toString();
//     }
// 	public static void main(String[] args) {
// 		  Solution s = new Solution();
// 		  System.out.println(s.addBinary("1", "11"));
// 	}

// }