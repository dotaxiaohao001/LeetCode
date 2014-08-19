import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
    	int len = s.length();
    	boolean[] R = new boolean[len+1];

    	R[0] = true; // empty
    	// R[i] means s[0,i-1] is satisfied
    	for(int i = 1; i <= len; ++i) {
    		for(int j = 0; j < i; ++j) {
    			//System.out.println(s.substring(j, i));
    			if(R[j] && dict.contains(s.substring(j, i))) { // [0-j-1]
    				R[i] = true;
    				break;
    			}
    		}
    	}
        return R[len];
    }
    
    public static void main(String[] args){
    		Solution s = new Solution();
    		HashSet<String> dict = new HashSet<String>();
    		dict.add("a");
    		dict.add("abc");
    		dict.add("b");
    		dict.add("cd");
    		System.out.println(s.wordBreak("abcd",dict));
    }
}