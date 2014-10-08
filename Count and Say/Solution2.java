/**
*思路： 基本就是求next permutation，比较直观，这里我多想了，题意理解错误，只需要以1开始的第n个sequence，
*加上注释部分可以求对于开始是n的第nthsequence，更加general，
*学了java 如果不是多线程用Stringbuilder 更好。
*
*/

public class Solution {
    public String countAndSay(int n) {
    	int d = n;
    	StringBuilder num = new StringBuilder("1");
//    	while(d > 0) {
//    		num.insert(0, n%10);
//    		d = d/10;
//    	}

    	//now generate n-1 time to get the nth sequence
    	for(int i = 1; i < n; ++i) {
    		num = getNextSequence(num);
    	}

    	return num.toString();

    }

    private StringBuilder getNextSequence(StringBuilder str) {
    	StringBuilder seq = new StringBuilder();
    	char pre = str.charAt(0);
    	int count = 1;
    	for(int i = 1; i < str.length(); ++i) {
    		if(str.charAt(i) == pre) {
    			count++;
    		} else {
    			seq.append(count);
    			seq.append(pre);
    			count = 1;
    			pre = str.charAt(i);
    		}
    	}
    	//process the last part
    	seq.append(count);
    	seq.append(pre);
    	return seq;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] num1 = {10,1,2,7,6,1,5};
    	System.out.println(s.countAndSay(2));
    }

}