import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> result = new ArrayList<String>();
        int len = s.length();
        if(s == null || len == 0)
        	return result;
        boolean[] R = new boolean[len+1];
        R[0] = true;
        for(int i = 1; i <= len; ++i) {
        	for(int j = 0; j < i; ++j) { 
        		if(R[j] && dict.contains(s.substring(j, i))){
        			R[i] = true;
        			break;
        		}
        	}
        }
        
        if(R[len] == false)// treaky solution
        	return result;
        
        ArrayList<String> ans = new ArrayList<String>();
        Solve(result, ans, s, dict, 0, len);
        return result;
    }

    private void Solve(ArrayList<String> result, ArrayList<String> ans, String s, Set<String> dict, int start, int len) {
    	if(start >= len) {
    		String str = new String();
    		for(int i = 0; i < ans.size(); ++i) {
    			if(i != 0)
    				str += " ";
    			str += ans.get(i);
    		}
    		result.add(str);
    	}

    	for(int i = start; i < len; ++i) {
    		String word = s.substring(start, i+1);
    		if(dict.contains(word)) {
    			ans.add(word);
    			Solve(result, ans, s, dict, i+1, len);
    			ans.remove(ans.size() - 1);
    		}
    	}
    }
    
    public static void main(String[] args){
    		Solution s = new Solution();
    		HashSet<String> dict = new HashSet<String>();
    		dict.add("cat");
    		dict.add("cats");
    		dict.add("and");
    		dict.add("sand");
    		dict.add("dog");
    		System.out.println(s.wordBreak("catsanddog",dict));
    }
}