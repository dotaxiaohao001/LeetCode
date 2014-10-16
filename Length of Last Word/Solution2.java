/**
*思路： 从后往前 就是找到第一个在满足array range 条件下的第一个非‘ ’的position， 然后记录end = cur+1， （类似substring里的end exclusive）
*然后找到最前面的非‘ ’位置，相减就好了。
*主要的难道就是corner case的判断，对于start position 后两个condition不是必要
*end 和start的default value。
*错误： i from len 
*/

public class Solution {
    public int lengthOfLastWord(String s) {
    	if(s == null || s.length() == 0) {
    		return 0;
    	}

    	int len = s.length();

    	int end = 0;
    	//find the end position
    	for(int i = len-1; i >= 0; --i) {
    		if(s.charAt(i) != ' ') {
    			end = i+1;
    			break;
    		}
    	}
    	int start = 0;
    	//find the start position
    	for(int i = end-1; i >= 0; --i) {
    		if(s.charAt(i) == ' ' && i+1 < len && s.charAt(i+1) != ' ') {
    			start = i+1;
    			break;
    		}
    	}
        
        return end - start;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.lengthOfLastWord("Hello World"));
	}

}